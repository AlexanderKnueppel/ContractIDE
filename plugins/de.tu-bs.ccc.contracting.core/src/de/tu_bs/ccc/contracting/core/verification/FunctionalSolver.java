package de.tu_bs.ccc.contracting.core.verification;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.Global;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Status;
import com.microsoft.z3.Symbol;

import de.tu_bs.ccc.contracting.Verification.Abstract;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.ViewPoint;
import de.tu_bs.ccc.contracting.core.util.CoreUtil;
import de.tu_bs.ccc.contracting.grammar.verification.GrammarSolver;
import de.tu_bs.ccc.contracting.idl.CidlPersistenceManager;
import de.tu_bs.ccc.contracting.idl.cidl.Argument;
import de.tu_bs.ccc.contracting.idl.cidl.Attribute;
import de.tu_bs.ccc.contracting.idl.cidl.BasicTypeId;
import de.tu_bs.ccc.contracting.idl.cidl.ContractPair;
import de.tu_bs.ccc.contracting.idl.cidl.Interface;
import de.tu_bs.ccc.contracting.idl.cidl.Method;
import de.tu_bs.ccc.contracting.idl.cidl.Model;
import de.tu_bs.ccc.contracting.ui.views.verification.VerificationViewElement;
import de.tu_bs.ccc.contracting.ui.views.verification.VerificationViewElement.Property;
import de.tu_bs.ccc.contracting.ui.views.verification.VerificationViewElement.Result;

public class FunctionalSolver implements IViewpointSolver {
	private Context ctx;
	private GrammarSolver gs;

	private ArrayList<VerificationViewElement> vve = null;

	public FunctionalSolver() {
		this.ctx = new Context();
		this.gs = new GrammarSolver();
		vve = new ArrayList<VerificationViewElement>();
	}

	@Override
	public String getName() {
		return "Functional ViewPointSolver";
	}

	@Override
	public boolean checkRealizability(Module m) {
		if (m instanceof Abstract) {
			Solver solver = this.ctx.mkSolver();
			ArrayList<String> methodContracts = new ArrayList<String>();
			ArrayList<String> methodInit = new ArrayList<String>();
			boolean contractIsMet = true;
			for (Module replacement : ((Abstract) m).getRealizes()) {
				replacement.getContract();
				ArrayList<Symbol> symbolList = new ArrayList<Symbol>();
				ArrayList<FuncDecl> funcDeclList = new ArrayList<FuncDecl>();
				ArrayList<Ports> p = new ArrayList<Ports>();

				for (Ports port : replacement.getPorts()) {
					p.add(port);
				}

				for (Ports port : m.getPorts()) {
					p.add(port);
				}

				// create symbols
				for (Ports elem : p) {
					if (elem.getType() == PortType.SERVICE) {
						List<Interface> interfaces = CidlPersistenceManager.getIdlModels(CoreUtil.getCurrentProject())
								.stream().map(mo -> ((Model) mo).getInterfaces()).flatMap(j -> j.stream())
								.collect(Collectors.toList());

						if (interfaces.stream().anyMatch(j -> j.getName().equals(elem.getService()))) {
							Interface serviceInterface = interfaces.stream()
									.filter(j -> j.getName().equals(elem.getService())).findFirst().get();
							for (Attribute attr : serviceInterface.getAttributes()) {
								String symbolname = elem.getModule().getName() + "." + elem.getName() + "."
										+ attr.getName();
								if (!symbolList.contains(this.ctx.mkSymbol(symbolname))) {
									funcDeclList.add(createFunction(this.ctx.mkSymbol(symbolname), attr.isArray(),
											attr.getType().getPredefined()));
								}
							}
							for (Method meth : serviceInterface.getMethods()) {
								String symbol = serviceInterface.getName() + "." + meth.getName();
								if (!symbolList.contains(this.ctx.mkSymbol(symbol))) {

									ArrayList<Argument> args = new ArrayList<Argument>();
									args.addAll(meth.getInArgs());
									args.addAll(meth.getOutArgs());
									for (ContractPair c : meth.getSpec().getContracts()) {

										String serviceContract = "(=> ";
										if (c.getReq().size() > 1) {
											serviceContract += "and (";
										}
										for (int i = 0; i < c.getReq().size(); i++) {

//									serviceContract += gs
//													.parseString(replacePortNamesFunc(c.getReq().get(i).getExpr(), args,
//															meth.getName(), serviceInterface.getName()));
										}
										if (c.getReq().size() > 1) {
											serviceContract += ")";
										}

										if (c.getEns().size() > 1) {
											serviceContract += "and (";
										}
										serviceContract += " ";
										for (int i = 0; i < c.getEns().size(); i++) {
//
//											serviceContract += gs
//													.parseString(replacePortNamesFunc(c.getEns().get(i).getExpr(), args,
//															meth.getName(), serviceInterface.getName()));
										}
										if (c.getEns().size() > 1) {
											serviceContract += ")";
										}
										serviceContract += ")";
										methodContracts.add(serviceContract);

									}
									ArrayList<Sort> paramlList = new ArrayList<Sort>();

									String funcInit = " (=(" + symbol;
									for (Argument argin : meth.getInArgs()) {
										String symbolname = serviceInterface.getName() + "." + meth.getName() + "."
												+ argin.getName();
										funcInit += " " + symbolname;
										Symbol s = this.ctx.mkSymbol(symbolname);
										symbolList.add(s);
										paramlList.add(createSort(argin.isArray(), argin.getType().getPredefined()));
										funcDeclList.add(
												createFunction(s, argin.isArray(), argin.getType().getPredefined()));
										if (argin.isArray()) {
											symbolList.add(this.ctx.mkSymbol(symbolname + ".length"));
											funcDeclList
													.add(this.ctx.mkConstDecl(symbolname + ".length", ctx.mkIntSort()));
										}
									}
									Sort funout = ctx.mkBoolSort();
									for (Argument argout : meth.getOutArgs()) {
										String symbolname = serviceInterface.getName() + "." + meth.getName() + "."
												+ argout.getName();
										Symbol s = this.ctx.mkSymbol(symbolname);
										symbolList.add(s);
										funout = createSort(argout.isArray(), argout.getType().getPredefined());
										funcDeclList.add(
												createFunction(s, argout.isArray(), argout.getType().getPredefined()));
										funcInit += ")" + symbolname + ")";
										methodInit.add(funcInit);

									}
									Symbol funsymb = this.ctx.mkSymbol(symbol);
									symbolList.add(funsymb);
									funcDeclList.add(this.ctx.mkFuncDecl(funsymb,
											paramlList.toArray(new Sort[paramlList.size()]), funout));
								}
							}
						}
					} else if (elem.getType() == PortType.DATA) {
						String symbolname = elem.getModule().getName() + "." + elem.getName();
						symbolList.add(this.ctx.mkSymbol(symbolname));
						System.out.println(symbolname);
						switch (elem.getService()) {
						case "int":
							funcDeclList.add(this.ctx.mkConstDecl(symbolname, this.ctx.getIntSort()));
							break;
						case "real":
							funcDeclList.add(this.ctx.mkConstDecl(symbolname, this.ctx.getRealSort()));
							break;
						case "bool":
							funcDeclList.add(this.ctx.mkConstDecl(symbolname, this.ctx.getBoolSort()));
							break;
						case "String":
							funcDeclList.add(this.ctx.mkConstDecl(symbolname, this.ctx.getStringSort()));
							break;
						case "int[]":
							funcDeclList
									.add(this.ctx.mkArrayConst(symbolname, this.ctx.getIntSort(), this.ctx.getIntSort())
											.getFuncDecl());
							break;
						case "real[]":
							funcDeclList.add(
									this.ctx.mkArrayConst(symbolname, this.ctx.getIntSort(), this.ctx.getRealSort())
											.getFuncDecl());
							break;
						case "bool[]":
							funcDeclList.add(
									this.ctx.mkArrayConst(symbolname, this.ctx.getIntSort(), this.ctx.getBoolSort())
											.getFuncDecl());
							break;
						case "String[]":
							funcDeclList.add(
									this.ctx.mkArrayConst(symbolname, this.ctx.getIntSort(), this.ctx.getStringSort())
											.getFuncDecl());
							break;

						}

					}
				}
				for (int i = 0; i < gs.getVisitor().getProductdef().size(); i++) {
					funcDeclList.add(
							this.ctx.mkFuncDecl("$product" + (i + 1), this.ctx.mkIntSort(), this.ctx.mkRealSort()));
					symbolList.add(this.ctx.mkSymbol("$product" + (i + 1)));
				}
				for (int i = 0; i < gs.getVisitor().getSumdef().size(); i++) {
					funcDeclList
							.add(this.ctx.mkFuncDecl("$sum" + (i + 1), this.ctx.mkIntSort(), this.ctx.mkRealSort()));
					symbolList.add(this.ctx.mkSymbol("$sum" + (i + 1)));
				}

				Symbol[] declNames = symbolList.toArray(new Symbol[0]);
				FuncDecl[] decl = funcDeclList.toArray(new FuncDecl[0]);

				for (Symbol funcDecl : declNames) {
					System.out.println(funcDecl.toString());
				}

				List<Ports> listOutput = m.getPorts().stream().filter(e -> replacement.getPorts().stream()
						.map(Ports::getName).anyMatch(name -> name.equals(e.getName()))).collect(Collectors.toList());
				for (Ports port : listOutput) {
					if (port.getType() == PortType.DATA) {

						solver.add(this.ctx.parseSMTLIB2String(
								"(assert (" + "= " + port.getModule().getName() + "." + port.getName() + " "
										+ replacement.getName() + "." + port.getName() + "))",
								null, null, declNames, decl));

					}

				}

				for (String meth : methodInit) {

					solver.add(this.ctx.parseSMTLIB2String("(assert " + meth + ")", null, null, declNames, decl));
					System.out.println("(assert " + meth + ")");
				}
				for (String meth : methodContracts) {

					solver.add(this.ctx.parseSMTLIB2String("(assert " + meth + ")", null, null, declNames, decl));
					System.out.println("(assert " + meth + ")");
				}
				for (String s : gs.getVisitor().getProductdef()) {
					System.out.println("(assert " + s + ")");
					solver.add((this.ctx.parseSMTLIB2String("(assert " + s + ")", null, null, declNames, decl)));
				}
				for (Contract c : replacement.getModule().getContract()) {
					if (c.getViewPoint().getValue() == ViewPoint.FUNCTIONAL_VALUE) {
						// try {
						solver.add(this.ctx.parseSMTLIB2String(this.getStringFuncofContract(c, true), null, null,
								declNames, decl));
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//					String x = "Error caused by: " + c.getModule().getName() + " " + c.getViewPoint();
//					JOptionPane.showMessageDialog(null, x, "Contract Parsing Error", JOptionPane.ERROR_MESSAGE);
//				}

					}
				}

				for (Contract con : m.getContract()) {
					if (con.getViewPoint().getValue() == ViewPoint.FUNCTIONAL_VALUE) {
						solver.push();

//			try {

						solver.add(this.ctx.parseSMTLIB2String(this.getStringFuncofContract(con, true), null, null,
								declNames, decl));

//			} catch (Exception e) {
//				throw e;
//				System.out.println(e.getMessage());
//				String x = "Error caused by: " + con.getModule().getName() + " " + con.getViewPoint();
//				JOptionPane.showMessageDialog(null, x, "Contract Parsing Error", JOptionPane.ERROR_MESSAGE);
//			}
						if (solver.check() == Status.SATISFIABLE) {
							vve.add(new VerificationViewElement(ViewPoint.FUNCTIONAL_VALUE,
									con.getGuarantee().toString() + con.getAssumption().toString(), m.getName(), m,
									Result.FAILED, Property.REALIZABILITY));
							contractIsMet = false;

						} else {

							vve.add(new VerificationViewElement(ViewPoint.FUNCTIONAL_VALUE,
									con.getGuarantee().toString() + con.getAssumption().toString(), m.getName(), m,
									Result.SUCCESS, Property.REALIZABILITY));
						}
						System.out.println("passiert");
						solver.pop();
					}
				}
				if (contractIsMet) {

				} else {

				}
				return contractIsMet;
			}
			return true;
		}
		return true;
	}

	@Override
	public boolean checkConsistency(Module m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkWellFormedness(Module m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkSubstitutability(Module m) {
		boolean contractIsMet = true;
		Solver solver = this.ctx.mkSolver();
		ArrayList<String> methodContracts = new ArrayList<String>();
		ArrayList<String> methodInit = new ArrayList<String>();
		ArrayList<String> subcompcontracts = new ArrayList<String>();
		ArrayList<String> comcontracts = new ArrayList<String>();
		Map<String, Integer> addedmethodcontracts = new HashMap<String, Integer>();
		if (m instanceof Compound) {
			for (Module component : ((Compound) m).getConsistsOf()) {
				for (Contract c : component.getModule().getContract()) {
					if (c.getViewPoint().getValue() == ViewPoint.FUNCTIONAL_VALUE) {
						// try {
						subcompcontracts.add(this.getStringofContract(c));

//						} catch (Exception e) {
//							System.out.println(e.getMessage());
//							String x = "Error caused by: " + c.getModule().getName() + " " + c.getViewPoint();
//							JOptionPane.showMessageDialog(null, x, "Contract Parsing Error", JOptionPane.ERROR_MESSAGE);
//						}

					}
				}
			}
			for (Contract con : m.getContract()) {
				if (con.getViewPoint().getValue() == ViewPoint.FUNCTIONAL_VALUE) {

					comcontracts.add(this.getStringFuncofContract(con, true));

				}
			}
			ArrayList<Ports> p = new ArrayList<Ports>();
			// add all Ports
			for (Module mod : ((Compound) m).getConsistsOf()) {
				for (Ports port : mod.getPorts()) {
					p.add(port);
				}
			}
			for (Ports port : m.getPorts()) {
				p.add(port);
			}

			ArrayList<Symbol> symbolList = new ArrayList<Symbol>();
			ArrayList<FuncDecl> funcDeclList = new ArrayList<FuncDecl>();

			// for each port declare them and define their variables
			for (Ports elem : p) {
				if (elem.getType() == PortType.SERVICE) {
					boolean allDefined = false;
					while (!allDefined) {
						System.out.println("Immer");
						boolean nochange = true;
						List<Interface> interfaces = CidlPersistenceManager.getIdlModels(CoreUtil.getCurrentProject())
								.stream().map(mo -> ((Model) mo).getInterfaces()).flatMap(j -> j.stream())
								.collect(Collectors.toList());

						if (interfaces.stream().anyMatch(j -> j.getName().equals(elem.getService()))) {
							Interface serviceInterface = interfaces.stream()
									.filter(j -> j.getName().equals(elem.getService())).findFirst().get();
							for (Attribute attr : serviceInterface.getAttributes()) {
								String symbolname = elem.getModule().getName() + "." + elem.getName() + "."
										+ attr.getName();
								if (!symbolList.contains(this.ctx.mkSymbol(symbolname))) {
									funcDeclList.add(createFunction(this.ctx.mkSymbol(symbolname), attr.isArray(),
											attr.getType().getPredefined()));
								}
							}
							for (Method meth : serviceInterface.getMethods()) {
								if (!addedmethodcontracts
										.containsKey(serviceInterface.getName() + "." + meth.getName())) {

									addedmethodcontracts.put(serviceInterface.getName() + "." + meth.getName(), 0);
								}
								String symbol = serviceInterface.getName() + "." + meth.getName();
								if (!symbolList.contains(this.ctx.mkSymbol(symbol))) {

									ArrayList<Sort> paramlList = new ArrayList<Sort>();
									for (Argument argin : meth.getInArgs()) {
										String symbolname = serviceInterface.getName() + "." + meth.getName() + "."
												+ argin.getName();

										paramlList.add(createSort(argin.isArray(), argin.getType().getPredefined()));

									}
									Sort funout = ctx.mkBoolSort();
									for (Argument argout : meth.getOutArgs()) {
										String symbolname = serviceInterface.getName() + "." + meth.getName() + "."
												+ argout.getName();

										funout = createSort(argout.isArray(), argout.getType().getPredefined());

									}
									Symbol funsymb = this.ctx.mkSymbol(symbol);
									symbolList.add(funsymb);
									funcDeclList.add(this.ctx.mkFuncDecl(funsymb,
											paramlList.toArray(new Sort[paramlList.size()]), funout));
								}
								if (gs.getVisitor().getFuncTupel()
										.get(serviceInterface.getName() + "." + meth.getName()) != null) {
									for (int j = addedmethodcontracts
											.get(serviceInterface.getName() + "." + meth.getName()); j < gs.getVisitor()
													.getFuncTupel()
													.get(serviceInterface.getName() + "." + meth.getName())
													.size(); j++) {
										System.out.println("Contract!!!!!!");
										addedmethodcontracts.put(serviceInterface.getName() + "." + meth.getName(),
												j + 1);
										nochange = false;
										ArrayList<Argument> args = new ArrayList<Argument>();
										args.addAll(meth.getInArgs());
										args.addAll(meth.getOutArgs());

										for (ContractPair c : meth.getSpec().getContracts()) {

											String serviceContract = "(=> ";
											if (c.getReq().size() > 1) {
												serviceContract += "and (";
											}
											for (int i = 0; i < c.getReq().size(); i++) {

												serviceContract += gs
														.parseString(replacePortNamesFunc(c.getReq().get(i).getExpr(),
																args, meth.getName(), serviceInterface.getName(), j));
											}
											if (c.getReq().size() > 1) {
												serviceContract += ")";
											}

											if (c.getEns().size() > 1) {
												serviceContract += "and (";
											}
											serviceContract += " ";
											for (int i = 0; i < c.getEns().size(); i++) {

												serviceContract += gs
														.parseString(replacePortNamesFunc(c.getEns().get(i).getExpr(),
																args, meth.getName(), serviceInterface.getName(), j));
											}
											if (c.getEns().size() > 1) {
												serviceContract += ")";
											}
											serviceContract += ")";
											methodContracts.add(serviceContract);

										}

										String funcInit = " (=(" + symbol;

										for (int i = 0; i < meth.getInArgs().size(); i++) {
											String symbolname = serviceInterface.getName() + "." + meth.getName() + "."
													+ meth.getInArgs().get(i).getName();
											funcInit += " " + symbolname;

											Symbol s = this.ctx.mkSymbol(symbolname);
											symbolList.add(s);

											funcDeclList.add(createFunction(s, meth.getInArgs().get(i).isArray(),
													meth.getInArgs().get(i).getType().getPredefined()));
											if (meth.getInArgs().get(i).isArray()) {
												symbolList.add(this.ctx.mkSymbol(symbolname + ".length"));
												funcDeclList.add(
														this.ctx.mkConstDecl(symbolname + ".length", ctx.mkIntSort()));
											}
											methodInit.add("(= " + symbolname + " "
													+ gs.getVisitor().getFuncTupel().get(symbol).get(j).get(i) + ")");

										}

										for (int i = 0; i < meth.getOutArgs().size(); i++) {
											String symbolname = serviceInterface.getName() + "." + meth.getName() + "."
													+ meth.getOutArgs().get(i).getName();
											Symbol s = this.ctx.mkSymbol(symbolname);
											symbolList.add(s);

											funcDeclList.add(createFunction(s, meth.getOutArgs().get(i).isArray(),
													meth.getOutArgs().get(i).getType().getPredefined()));
											funcInit += ")" + symbolname + ")";
											// methodInit.add("(= " + symbolname + " " + gs.getVisitor().getFuncTupel()
											// .get(symbol).get(j).get(meth.getInArgs().size() + i));
											methodInit.add(funcInit);

										}

									}
								}
							}
						}

						if (nochange) {
							allDefined = true;

						}
					}
				} else if (elem.getType() == PortType.DATA) {
					String symbolname = elem.getModule().getName() + "." + elem.getName();
					symbolList.add(this.ctx.mkSymbol(symbolname));
					System.out.println(symbolname);
					switch (elem.getService()) {
					case "int":
						funcDeclList.add(this.ctx.mkConstDecl(symbolname, this.ctx.getIntSort()));
						break;
					case "real":
						funcDeclList.add(this.ctx.mkConstDecl(symbolname, this.ctx.getRealSort()));
						break;
					case "bool":
						funcDeclList.add(this.ctx.mkConstDecl(symbolname, this.ctx.getBoolSort()));
						break;
					case "String":
						funcDeclList.add(this.ctx.mkConstDecl(symbolname, this.ctx.getStringSort()));
						break;
					case "int[]":
						funcDeclList.add(this.ctx.mkArrayConst(symbolname, this.ctx.getIntSort(), this.ctx.getIntSort())
								.getFuncDecl());
						break;
					case "real[]":
						funcDeclList.add(this.ctx
								.mkArrayConst(symbolname, this.ctx.getIntSort(), this.ctx.getRealSort()).getFuncDecl());
						break;
					case "bool[]":
						funcDeclList.add(this.ctx
								.mkArrayConst(symbolname, this.ctx.getIntSort(), this.ctx.getBoolSort()).getFuncDecl());
						break;
					case "String[]":
						funcDeclList
								.add(this.ctx.mkArrayConst(symbolname, this.ctx.getIntSort(), this.ctx.getStringSort())
										.getFuncDecl());
						break;

					}

				}
			}
			for (int i = 0; i < gs.getVisitor().getProductdef().size(); i++) {
				funcDeclList.add(this.ctx.mkFuncDecl("$product" + (i), this.ctx.mkIntSort(), this.ctx.mkRealSort()));
				symbolList.add(this.ctx.mkSymbol("$product" + (i)));
			}
			for (int i = 0; i < gs.getVisitor().getSumdef().size(); i++) {
				funcDeclList.add(this.ctx.mkFuncDecl("$sum" + (i), this.ctx.mkIntSort(), this.ctx.mkRealSort()));
				symbolList.add(this.ctx.mkSymbol("$sum" + (i)));
			}

			Symbol[] declNames = symbolList.toArray(new Symbol[0]);
			FuncDecl[] decl = funcDeclList.toArray(new FuncDecl[0]);

			for (Symbol funcDecl : declNames) {
				System.out.println("(declare-fun " + funcDecl.toString() + "() Real)");
			}
			for (Ports port : p) {
				if (port.getType() == PortType.DATA) {

					for (Ports oppositePort : port.getPorts()) {
						System.out.println("(assert (" + "= " + port.getModule().getName() + "." + port.getName() + " "
								+ oppositePort.getModule().getName() + "." + oppositePort.getName() + "))");
						solver.add(this.ctx.parseSMTLIB2String(
								"(assert (" + "= " + port.getModule().getName() + "." + port.getName() + " "
										+ oppositePort.getModule().getName() + "." + oppositePort.getName() + "))",
								null, null, declNames, decl));

					}
					for (Ports endport : port.getInsidePorts()) {
						if (endport.getModule().getName().equals(m.getName())) {
							System.out.println(
									"(assert (" + "= " + endport.getModule().getName() + "." + endport.getName() + " "
											+ port.getModule().getName() + "." + port.getName() + "))");
							solver.add(this.ctx.parseSMTLIB2String(
									"(assert (" + "= " + endport.getModule().getName() + "." + endport.getName() + " "
											+ port.getModule().getName() + "." + port.getName() + "))",
									null, null, declNames, decl));

						}
					}
				}
			}

			for (Ports port : m.getPorts()) {
				if (port.getType() == PortType.DATA) {
					for (Ports oppositePort : port.getInsidePorts()) {
						System.out.println("(assert (" + "= " + port.getModule().getName() + "." + port.getName() + " "
								+ oppositePort.getModule().getName() + "." + oppositePort.getName() + "))");
						solver.add(this.ctx.parseSMTLIB2String(
								"(assert (" + "= " + port.getModule().getName() + "." + port.getName() + " "
										+ oppositePort.getModule().getName() + "." + oppositePort.getName() + "))",
								null, null, declNames, decl));

					}

				}
			}

			for (String meth : methodInit) {

				solver.add(this.ctx.parseSMTLIB2String("(assert " + meth + ")", null, null, declNames, decl));
				System.out.println("(assert " + meth + ")");
			}
			for (String meth : methodContracts) {

				solver.add(this.ctx.parseSMTLIB2String("(assert " + meth + ")", null, null, declNames, decl));
				System.out.println("(assert " + meth + ")");
			}
			for (String s : gs.getVisitor().getProductdef()) {

				solver.add((this.ctx.parseSMTLIB2String("(assert " + s + ")", null, null, declNames, decl)));
				System.out.println("(assert " + s + ")");
			}
			for (String contract : subcompcontracts) {
				solver.add(this.ctx.parseSMTLIB2String(contract, null, null, declNames, decl));
				System.out.println(contract);
			}

			for (String contract : comcontracts) {
				solver.push();
				System.out.println(contract);
				solver.add(this.ctx.parseSMTLIB2String(contract, null, null, declNames, decl));
				Global.setParameter("smt.mbqi", "true");

//					} catch (Exception e) {
//						throw e;
//						System.out.println(e.getMessage());
//						String x = "Error caused by: " + con.getModule().getName() + " " + con.getViewPoint();
//						JOptionPane.showMessageDialog(null, x, "Contract Parsing Error", JOptionPane.ERROR_MESSAGE);
//					}
				Status s = solver.check();
				if (s == Status.UNKNOWN || s == Status.SATISFIABLE) {
					vve.add(new VerificationViewElement(ViewPoint.FUNCTIONAL_VALUE, solver.getModel().toString(),
							m.getName(), m, Result.FAILED, Property.SUBSTITUTABILITY));
					System.out.println("not");
					contractIsMet = false;

				} else {
					System.out.println("allfine");
					vve.add(new VerificationViewElement(ViewPoint.FUNCTIONAL_VALUE, "Fehler", m.getName(), m,
							Result.SUCCESS, Property.SUBSTITUTABILITY));
				}

				solver.pop();
			}
		}

		return contractIsMet;
	}

	@Override
	public ArrayList<VerificationViewElement> getSummary() {
		// TODO Auto-generated method stub
		return vve;
	}

	String getStringFuncofContract(Contract c, boolean correct) {
		String cont = new String("(define-fun ValidContract () Bool (");
		if (correct) {
			cont += "=> ";
		} else {
			cont += "not (=> ";
		}

		if (c.getAssumption().size() == 0) {
			cont = cont + "true ";

		} else if (c.getAssumption().size() == 1) {
			cont = cont + this.gs
					.parseString(this.replacePortNamesFunc(c.getAssumption().get(0).getProperty(), c.getModule()));

		} else {
			cont = cont + "(and";
			for (int i = 0; i < c.getAssumption().size(); i++) {
				cont = cont + " " + this.gs
						.parseString(this.replacePortNamesFunc(c.getAssumption().get(i).getProperty(), c.getModule()));

			}
			cont = cont + ")";

		}
		if (c.getGuarantee().size() == 0) {
			cont = cont + "true ";

		} else if (c.getGuarantee().size() == 1) {
			cont = cont + this.gs
					.parseString(this.replacePortNamesFunc(c.getGuarantee().get(0).getProperty(), c.getModule()));

		} else {
			cont = cont + "(and";
			for (int i = 0; i < c.getGuarantee().size(); i++) {
				cont = cont + " " + this.gs
						.parseString(this.replacePortNamesFunc(c.getGuarantee().get(i).getProperty(), c.getModule()));

			}
			cont = cont + ")";

		}
		cont = cont + "))";
		cont = this.replacePortNamesFunc(cont, c.getModule());
		if (!correct) {
			cont += ")";
		}
		cont = cont + "(assert (not ValidContract))";

		return cont;

	}

	String replacePortNamesFunc(String constraint, Module m) {

		for (Ports port : m.getPorts()) {
			if (port.getType() == PortType.DATA) {
				constraint = constraint.replaceAll(
						"(^)" + port.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + port.getName()
								+ "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + port.getName() + "($)",
						"$1$3$5" + m.getName() + "." + port.getName() + "$2$4$6");
				constraint = constraint.replaceAll(
						"(^)" + port.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + port.getName()
								+ "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + port.getName() + "($)",
						"$1$3$5" + m.getName() + "." + port.getName() + "$2$4$6");
			} else {
				constraint = constraint.replaceAll(
						"(^)" + port.getName() + "([.])" + "|([^a-zA-Z0-9.])" + port.getName() + "+([.])",
						"$1$3" + port.getService() + "$2$4");
				constraint = constraint.replaceAll(
						"(^)" + port.getName() + "([.])" + "|([^a-zA-Z0-9.])" + port.getName() + "+([.])",
						"$1$3" + port.getService() + "$2$4");
			}
		}
		return constraint;

	}

	String getStringofContract(Contract c) {
		String cont = new String("(assert(=> ");
		if (c.getAssumption().size() == 0) {
			cont = cont + "true ";

		} else if (c.getAssumption().size() == 1) {
			cont = cont + " " + this.gs
					.parseString(this.replacePortNamesFunc(c.getAssumption().get(0).getProperty(), c.getModule()));

		} else {
			cont = cont + "(and";
			for (int i = 0; i < c.getAssumption().size(); i++) {
				cont = cont + " " + this.gs
						.parseString(this.replacePortNamesFunc(c.getAssumption().get(i).getProperty(), c.getModule()));

			}
			cont = cont + ")";

		}
		cont = cont + " ";
		if (c.getGuarantee().size() == 0) {
			cont = cont + "true ";

		} else if (c.getGuarantee().size() == 1) {
			cont = cont + this.gs
					.parseString(this.replacePortNamesFunc(c.getGuarantee().get(0).getProperty(), c.getModule()));

		} else {
			cont = cont + "(and";
			for (int i = 0; i < c.getGuarantee().size(); i++) {
				cont = cont + this.gs
						.parseString(this.replacePortNamesFunc(c.getGuarantee().get(i).getProperty(), c.getModule()));

			}
			cont = cont + ")";

		}
		cont = cont + "))";
		cont = this.replacePortNamesFunc(cont, c.getModule());
		return cont;

	}

	String replacePortNamesFunc(String constraint, ArrayList<Argument> args, String meth, String service, int i) {

		String cons = constraint;
		String x = new String("");
		if (i > 0) {
			x = "" + i;
		}
		for (Argument arg : args) {
			if (arg.isArray()) {
				cons = cons.replaceAll(
						"(^)" + arg.getName() + ".length" + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + arg.getName()
								+ ".length" + "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + arg.getName() + ".length"
								+ "($)",
						"$1$3$5" + service + "." + meth + "." + arg.getName() + x + ".length" + "$2$4$6");
				cons = cons.replaceAll(
						"(^)" + arg.getName() + ".length" + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + arg.getName()
								+ ".length" + "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + arg.getName() + ".length"
								+ "($)",
						"$1$3$5" + service + "." + meth + "." + arg.getName() + x + ".length" + "$2$4$6");

			}

			cons = cons.replaceAll(
					"(^)" + arg.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + arg.getName() + "+([^a-zA-Z0-9.])"
							+ "|([^a-zA-Z0-9.])+" + arg.getName() + "($)",
					"$1$3$5" + service + "." + meth + "." + arg.getName() + x + "$2$4$6");
			cons = cons.replaceAll(
					"(^)" + arg.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + arg.getName() + "+([^a-zA-Z0-9.])"
							+ "|([^a-zA-Z0-9.])+" + arg.getName() + "($)",
					"$1$3$5" + service + "." + meth + "." + arg.getName() + x + "$2$4$6");
		}

		return cons;

	}

	FuncDecl createFunction(Symbol s, boolean arg, BasicTypeId c) {
		FuncDecl f = null;

		if (arg) {

			switch (c.getValue()) {
			case BasicTypeId.BOOLEAN_VALUE:
				f = this.ctx.mkArrayConst(s, ctx.mkIntSort(), ctx.mkBoolSort()).getFuncDecl();
				break;
			case BasicTypeId.FLOAT_VALUE:
			case BasicTypeId.DOUBLE_VALUE:

				f = this.ctx.mkArrayConst(s, ctx.mkIntSort(), ctx.mkRealSort()).getFuncDecl();
				break;
			case BasicTypeId.STRING_VALUE:

				f = this.ctx.mkArrayConst(s, ctx.mkIntSort(), ctx.mkStringSort()).getFuncDecl();
				break;
			default:
				f = this.ctx.mkArrayConst(s, ctx.mkIntSort(), ctx.mkIntSort()).getFuncDecl();
				break;
			}

		} else {
			switch (c.getValue()) {
			case BasicTypeId.BOOLEAN_VALUE:
				f = this.ctx.mkConstDecl(s, ctx.mkBoolSort());

				break;
			case BasicTypeId.FLOAT_VALUE:
				f = (this.ctx.mkConstDecl(s, ctx.mkRealSort()));
			case BasicTypeId.DOUBLE_VALUE:
				f = (this.ctx.mkConstDecl(s, ctx.mkRealSort()));
				break;
			case BasicTypeId.STRING_VALUE:
				f = this.ctx.mkConstDecl(s, ctx.mkStringSort());
				break;
			default:
				f = this.ctx.mkConstDecl(s, ctx.mkIntSort());
				break;
			}
		}
		return f;
	}

	Sort createSort(boolean arg, BasicTypeId c) {
		Sort f = null;

		if (arg) {

			switch (c.getValue()) {
			case BasicTypeId.BOOLEAN_VALUE:
				f = this.ctx.mkArraySort(ctx.mkIntSort(), ctx.mkBoolSort());
				break;
			case BasicTypeId.FLOAT_VALUE:
			case BasicTypeId.DOUBLE_VALUE:

				f = this.ctx.mkArraySort(ctx.mkIntSort(), ctx.mkRealSort());
				break;
			case BasicTypeId.STRING_VALUE:

				f = this.ctx.mkArraySort(ctx.mkIntSort(), ctx.mkStringSort());
				break;
			default:
				f = this.ctx.mkArraySort(ctx.mkIntSort(), ctx.mkIntSort());
				break;
			}

		} else {
			switch (c.getValue()) {
			case BasicTypeId.BOOLEAN_VALUE:
				f = this.ctx.mkBoolSort();

				break;
			case BasicTypeId.FLOAT_VALUE:
				f = this.ctx.mkRealSort();
			case BasicTypeId.DOUBLE_VALUE:
				f = this.ctx.mkRealSort();
				break;
			case BasicTypeId.STRING_VALUE:
				f = this.ctx.mkStringSort();
				break;
			default:
				f = this.ctx.getIntSort();
				break;
			}
		}
		return f;
	}

}
