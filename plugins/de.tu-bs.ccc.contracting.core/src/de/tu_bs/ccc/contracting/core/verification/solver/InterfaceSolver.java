//package de.tu_bs.ccc.contracting.core.verification.solver;
//
//import java.util.ArrayList;
//
//import org.eclipse.emf.common.util.URI;
//
//import com.microsoft.z3.Context;
//import com.microsoft.z3.FuncDecl;
//import com.microsoft.z3.Solver;
//import com.microsoft.z3.Status;
//import com.microsoft.z3.Symbol;
//import com.microsoft.z3.Z3Exception;
//
//import de.tu_bs.ccc.contracting.Verification.Abstract;
//import de.tu_bs.ccc.contracting.Verification.Assumption;
//import de.tu_bs.ccc.contracting.Verification.Contract;
//import de.tu_bs.ccc.contracting.Verification.ContractProperty;
//import de.tu_bs.ccc.contracting.Verification.Guarantee;
//import de.tu_bs.ccc.contracting.Verification.Module;
//import de.tu_bs.ccc.contracting.Verification.PortType;
//import de.tu_bs.ccc.contracting.Verification.Ports;
//import de.tu_bs.ccc.contracting.Verification.PropertyType;
//import de.tu_bs.ccc.contracting.Verification.ViewPoint;
//import de.tu_bs.ccc.contracting.core.verification.grammar.GrammarSolver;
//
//public class InterfaceSolver {
//
//	public InterfaceSolver(Module m, Abstract c) {
//
//		super();
//		this.m = m;
//		this.c = c;
//	}
//
//	GrammarSolver gs = new GrammarSolver();
//	private Context ctx = new Context();
//	private Module m;
//	private Abstract c;
//
//	public boolean validInstance() {
//		int[][] combination = new int[c.getPorts().size()][2];
//		return recursiveValidation(combination);
//
//	}
//
//	/**
//	 * @param combination
//	 * @return
//	 */
//	private boolean recursiveValidation(int[][] combination) {
//		for (int i = 0; i < c.getPorts().size(); i++) {
//			for (int j = 0; j < m.getPorts().size(); j++) {
//				if (c.getPorts().get(i).getName().equals(m.getPorts().get(j).getName())) {
//					combination[i][0] = i;
//					combination[i][1] = j;
//				}
//			}
//		}
//		System.out.println(checkFunctional(combination));
//		System.out.println(checkMemory(combination));
//		System.out.println(checkTiming(combination));
//		return checkCombination(combination);
//
//	}
//
//	// if (combination.length == m.getPorts().size()) {
//	// String comb = new String("Teste: ");
//	//// for (int i = 0; i < combination.length; i++) {
//	//// comb = comb + Arrays.toString(combination[i]);
//	//// }
//	//// System.out.println(comb);
//	//
//	//
//	// return checkCombination(combination);
//	//
//	// }
//	//
//	// for (int i = 0; i < this.c.getPorts().size(); i++) {
//	// for (int j = 0; j < this.m.getPorts().size(); j++) {
//	// if ((!this.arrayContains(combination, 0, i)) &&
//	// (!this.arrayContains(combination, 1, j) && (this.c
//	// .getPorts().get(i).getType().getValue() ==
//	// this.m.getPorts().get(j).getType().getValue()))) {
//	// int[][] newCombination = new int[combination.length + 1][2];
//	// for (int k = 0; k < combination.length; k++) {
//	// newCombination[k][1] = combination[k][1];
//	// newCombination[k][0] = combination[k][0];
//	// }
//	// newCombination[newCombination.length - 1][0] = i;
//	// newCombination[newCombination.length - 1][1] = j;
//	// if (recursiveValidation(newCombination)) {
//	// return true;
//	// }
//	// }
//	// }
//	// }
//	// return false;
//
//	private boolean checkCombination(int[][] combination) {
//
//		return checkFunctional(combination) && checkMemory(combination) && checkTiming(combination);
//
//	}
//
//	private boolean checkFunctional(int[][] combination) {
//		boolean contractsMet = true;
//		ArrayList<Ports> p = new ArrayList<Ports>();
//		for (Ports ports : this.c.getPorts()) {
//			p.add(ports);
//		}
//		for (Ports ports : this.m.getPorts()) {
//			p.add(ports);
//		}
//
//		Symbol[] declNames = new Symbol[p.size()];
//		FuncDecl[] decl = new FuncDecl[p.size()];
//		for (int i = 0; i < decl.length; i++) {
//			declNames[i] = this.ctx.mkSymbol(p.get(i).getModule().getName() + "." + p.get(i).getName());
//			switch (p.get(i).getType().getValue()) {
//
//			case PortType.BOOLEAN_VALUE:
//				decl[i] = this.ctx.mkConstDecl(declNames[i], ctx.mkBoolSort());
//				break;
//			case PortType.REAL_VALUE:
//				decl[i] = this.ctx.mkConstDecl(declNames[i], ctx.mkRealSort());
//				break;
//			case PortType.STRING_VALUE:
//				decl[i] = this.ctx.mkConstDecl(declNames[i], ctx.mkStringSort());
//				break;
//
//			default:
//				decl[i] = this.ctx.mkConstDecl(declNames[i], ctx.mkIntSort());
//				break;
//			}
//
//		}
//		Solver solver = this.ctx.mkSolver();
//		for (int i = 0; i < combination.length; i++) {
//			solver.add(
//					this.ctx.parseSMTLIB2String(
//							"(assert (" + "= " + m.getPorts().get(combination[i][1]).getModule().getName() + "."
//									+ m.getPorts().get(combination[i][1]).getName() + " "
//									+ c.getPorts().get(combination[i][0]).getModule().getName() + "."
//									+ c.getPorts().get(combination[i][0]).getName() + "))",
//							null, null, declNames, decl));
//		}
//		for (Contract c : m.getContract()) {
//			if (c.getViewPoint().getValue() == ViewPoint.FUNCTIONAL_VALUE) {
//
//				solver.add(this.ctx.parseSMTLIB2String(this.getStringofContract(c), null, null, declNames, decl));
//			}
//		}
//
//		for (Contract con : this.c.getContract()) {
//			if (con.getViewPoint().getValue() == ViewPoint.FUNCTIONAL_VALUE) {
//				solver.push();
//
//				solver.add(this.ctx.parseSMTLIB2String(this.getStringFuncofContract(con), null, null, declNames, decl));
//				if (solver.check() == Status.SATISFIABLE) {
//					contractsMet = false;
//					URI fileURI = this.c.eResource().getURI();
//					fileURI = fileURI.trimFileExtension();
//
//				}
//				solver.pop();
//			}
//		}
//
//		return contractsMet;
//	}
//
//	private boolean checkTiming(int[][] combination) {
//		boolean contractsMet = true;
//
//		ArrayList<Ports> p = new ArrayList<Ports>();
//		for (Ports ports : this.c.getPorts()) {
//			p.add(ports);
//		}
//		for (Ports ports : this.m.getPorts()) {
//			p.add(ports);
//		}
//
//		Symbol[] declNames = new Symbol[(p.size() * 4) + 4];
//		FuncDecl[] decl = new FuncDecl[(p.size() * 4) + 4];
//		for (int i = 0; i < p.size(); i++) {
//			declNames[i * 4] = this.ctx
//					.mkSymbol(p.get(i).getModule().getName() + "." + p.get(i).getName() + "." + "minduration");
//			declNames[(i * 4) + 1] = this.ctx
//					.mkSymbol(p.get(i).getModule().getName() + "." + p.get(i).getName() + "." + "maxduration");
//			declNames[(i * 4) + 2] = this.ctx
//					.mkSymbol(p.get(i).getModule().getName() + "." + p.get(i).getName() + "." + "frequency");
//			declNames[(i * 4) + 3] = this.ctx
//					.mkSymbol(p.get(i).getModule().getName() + "." + p.get(i).getName() + "." + "jitter");
//			decl[i * 4] = this.ctx.mkConstDecl(declNames[i * 4], ctx.mkRealSort());
//			decl[(i * 4) + 1] = this.ctx.mkConstDecl(declNames[(i * 4) + 1], ctx.mkRealSort());
//			decl[(i * 4) + 2] = this.ctx.mkConstDecl(declNames[(i * 4) + 2], ctx.mkRealSort());
//			decl[(i * 4) + 3] = this.ctx.mkConstDecl(declNames[(i * 4) + 3], ctx.mkRealSort());
//
//		}
//		declNames[declNames.length - 1] = this.ctx.mkSymbol(c.getName() + "." + "mindelay");
//		declNames[declNames.length - 2] = this.ctx.mkSymbol(c.getName() + "." + "maxdelay");
//		declNames[declNames.length - 3] = this.ctx.mkSymbol(m.getName() + "." + "mindelay");
//		declNames[declNames.length - 4] = this.ctx.mkSymbol(m.getName() + "." + "maxdelay");
//		decl[decl.length - 1] = this.ctx.mkConstDecl(declNames[declNames.length - 1], ctx.mkRealSort());
//		decl[decl.length - 2] = this.ctx.mkConstDecl(declNames[declNames.length - 2], ctx.mkRealSort());
//		decl[decl.length - 3] = this.ctx.mkConstDecl(declNames[declNames.length - 3], ctx.mkRealSort());
//		decl[decl.length - 4] = this.ctx.mkConstDecl(declNames[declNames.length - 4], ctx.mkRealSort());
//
//		Solver solver = this.ctx.mkSolver();
//		for (int i = 0; i < combination.length; i++) {
//			solver.add(this.ctx.parseSMTLIB2String(
//					"(assert (" + "= " + m.getPorts().get(combination[i][1]).getModule().getName() + "."
//							+ m.getPorts().get(combination[i][1]).getName() + ".minduration" + " "
//							+ c.getPorts().get(combination[i][0]).getModule().getName() + "."
//							+ c.getPorts().get(combination[i][0]).getName() + ".minduration" + "))",
//					null, null, declNames, decl));
//			solver.add(this.ctx.parseSMTLIB2String(
//					"(assert (" + "= " + m.getPorts().get(combination[i][1]).getModule().getName() + "."
//							+ m.getPorts().get(combination[i][1]).getName() + ".frequency" + " "
//							+ c.getPorts().get(combination[i][0]).getModule().getName() + "."
//							+ c.getPorts().get(combination[i][0]).getName() + ".frequency" + "))",
//					null, null, declNames, decl));
//			solver.add(this.ctx.parseSMTLIB2String(
//					"(assert (" + "= " + m.getPorts().get(combination[i][1]).getModule().getName() + "."
//							+ m.getPorts().get(combination[i][1]).getName() + ".maxduration" + " "
//							+ c.getPorts().get(combination[i][0]).getModule().getName() + "."
//							+ c.getPorts().get(combination[i][0]).getName() + ".maxduration" + "))",
//					null, null, declNames, decl));
//			solver.add(this.ctx.parseSMTLIB2String(
//					"(assert (" + "= " + m.getPorts().get(combination[i][1]).getModule().getName() + "."
//							+ m.getPorts().get(combination[i][1]).getName() + ".jitter" + " "
//							+ c.getPorts().get(combination[i][0]).getModule().getName() + "."
//							+ c.getPorts().get(combination[i][0]).getName() + ".jitter" + "))",
//					null, null, declNames, decl));
//		}
//		solver.add(this.ctx.parseSMTLIB2String(
//				"(assert (" + "= " + m.getName() + ".mindelay" + " " + c.getName() + ".mindelay" + "))", null, null,
//				declNames, decl));
//		solver.add(this.ctx.parseSMTLIB2String(
//				"(assert (" + "= " + m.getName() + ".maxdelay" + " " + c.getName() + ".maxdelay" + "))", null, null,
//				declNames, decl));
//
//		for (Contract c : m.getContract()) {
//			if (c.getViewPoint().getValue() == ViewPoint.TIMING_VALUE) {
//				try {
//					solver.add(this.ctx.parseSMTLIB2String(this.getTimingStringofContract(c), null, null, declNames,
//							decl));
//				} catch (Z3Exception e) {
//					System.out.println(e);
//				}
//
//			}
//
//		}
//		for (Contract con : this.c.getContract()) {
//			if (con.getViewPoint().getValue() == ViewPoint.TIMING_VALUE) {
//				solver.push();
//				solver.add(this.ctx.parseSMTLIB2String(this.getTimingFuncStringofContract(con), null, null, declNames,
//						decl));
//				if (solver.check() == Status.SATISFIABLE) {
//					contractsMet = false;
//					URI fileURI = this.c.eResource().getURI();
//					fileURI = fileURI.trimFileExtension();
//					System.out.println(solver);
//					System.out.println(solver.getModel());
//
//				}
//				solver.pop();
//			}
//		}
//
//		return contractsMet;
//
//	}
//
//	private boolean checkMemory(int[][] combination) {
//		boolean isVerified = true;
//		Symbol[] declNames = new Symbol[2];
//		FuncDecl[] decl = new FuncDecl[2];
//		declNames[1] = this.ctx.mkSymbol("Interface.Memory");
//		declNames[0] = this.ctx.mkSymbol("Module.Memory");
//		decl[0] = this.ctx.mkConstDecl(declNames[0], ctx.mkRealSort());
//		decl[1] = this.ctx.mkConstDecl(declNames[1], ctx.mkRealSort());
//		Solver s = this.ctx.mkSolver();
//
//		for (Contract cont : this.c.getContract()) {
//			if (cont.getViewPoint().getValue() == ViewPoint.MEMORY_VALUE) {
//				for (Contract mcont : this.m.getContract()) {
//					if (mcont.getViewPoint().getValue() == ViewPoint.MEMORY_VALUE) {
//
//						s.add(ctx.parseSMTLIB2String("(assert (= Interface.Memory Module.Memory))", null, null,
//								declNames, decl));
//						String inter = cont.getGuarantee().get(0).getProperty().replaceAll("Memory",
//								"Interface.Memory");
//						String mod = mcont.getGuarantee().get(0).getProperty().replaceAll("Memory", "Module.Memory");
//						s.add(ctx.parseSMTLIB2String(
//								"(define-fun ValidContract () Bool (=> " + this.gs.parseString(mod) + " "
//										+ this.gs.parseString(inter) + "))(assert (not ValidContract))",
//								null, null, declNames, decl));
//						if (s.check() == Status.SATISFIABLE) {
//							isVerified = false;
//							URI fileURI = this.c.eResource().getURI();
//							fileURI = fileURI.trimFileExtension();
//
//						}
//
//					}
//
//				}
//			}
//
//		}
//
//		return isVerified;
//
//	}
//
//	boolean arrayContains(int[][] combination, int row, int number) {
//		for (int i = 0; i < combination.length; i++) {
//			if (combination[i][row] == number) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	String replacePortNamesFunc(String constraint, Module m) {
//		for (Ports port : m.getPorts()) {
//			constraint = constraint.replaceAll(
//					"(^)" + port.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + port.getName()
//							+ "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + port.getName() + "($)",
//					"$1$3$5" + m.getName() + "." + port.getName() + "$2$4$6");
//			constraint = constraint.replaceAll(
//					"(^)" + port.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + port.getName()
//							+ "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + port.getName() + "($)",
//					"$1$3$5" + m.getName() + "." + port.getName() + "$2$4$6");
//		}
//		return constraint;
//
//	}
//
//	String getStringofContract(Contract c) {
//		String cont = new String("(assert(=> ");
//		if (c.getAssumption().size() == 0) {
//			cont = cont + "true ";
//
//		} else if (c.getAssumption().size() == 1) {
//			cont = cont + this.gs.parseString(c.getAssumption().get(0).getProperty());
//
//		} else {
//			cont = cont + "(and";
//			for (int i = 0; i < c.getAssumption().size(); i++) {
//				cont = cont + " " + this.gs.parseString(c.getAssumption().get(i).getProperty());
//
//			}
//			cont = cont + ")";
//
//		}
//		if (c.getGuarantee().size() == 0) {
//			cont = cont + "true ";
//
//		} else if (c.getGuarantee().size() == 1) {
//			cont = cont + this.gs.parseString(c.getGuarantee().get(0).getProperty());
//
//		} else {
//			cont = cont + "(and";
//			for (int i = 0; i < c.getGuarantee().size(); i++) {
//				cont = cont + " " + this.gs.parseString(c.getGuarantee().get(i).getProperty());
//
//			}
//			cont = cont + ")";
//
//		}
//		cont = cont + "))";
//		cont = this.replacePortNamesFunc(cont, c.getModule());
//		return cont;
//
//	}
//
//	String getStringFuncofContract(Contract c) {
//		String cont = new String("(define-fun ValidContract () Bool (=> ");
//		if (c.getAssumption().size() == 0) {
//			cont = cont + "true ";
//
//		} else if (c.getAssumption().size() == 1) {
//			cont = cont + this.gs.parseString(c.getAssumption().get(0).getProperty());
//
//		} else {
//			cont = cont + "(and";
//			for (int i = 0; i < c.getAssumption().size(); i++) {
//				cont = cont + " " + this.gs.parseString(c.getAssumption().get(i).getProperty());
//
//			}
//			cont = cont + ")";
//
//		}
//		if (c.getGuarantee().size() == 0) {
//			cont = cont + "true ";
//
//		} else if (c.getGuarantee().size() == 1) {
//			cont = cont + this.gs.parseString(c.getGuarantee().get(0).getProperty());
//
//		} else {
//			cont = cont + "(and";
//			for (int i = 0; i < c.getGuarantee().size(); i++) {
//				cont = cont + " " + this.gs.parseString(c.getGuarantee().get(i).getProperty());
//
//			}
//			cont = cont + ")";
//
//		}
//		cont = cont + "))";
//		cont = cont + "(assert (not ValidContract))";
//		cont = this.replacePortNamesFunc(cont, c.getModule());
//		return cont;
//
//	}
//
//	String getTimingStringofContract(Contract c) {
//		String cont = new String("(assert(=> ");
//		if (c.getAssumption().size() == 0) {
//			cont = cont + "true ";
//
//		} else if (c.getAssumption().size() == 1) {
//			cont = cont + this.gs.parseString(this.replacePortsTiming(c.getAssumption().get(0)));
//
//		} else {
//			cont = cont + "(and";
//			for (int i = 0; i < c.getAssumption().size(); i++) {
//				cont = cont + " " + this.gs.parseString(this.replacePortsTiming(c.getAssumption().get(i)));
//
//			}
//			cont = cont + ")";
//
//		}
//		if (c.getGuarantee().size() == 0) {
//			cont = cont + "true ";
//
//		} else if (c.getGuarantee().size() == 1) {
//			cont = cont + this.gs.parseString(this.replacePortsTiming(c.getGuarantee().get(0)));
//
//		} else {
//			cont = cont + "(and";
//			for (int i = 0; i < c.getGuarantee().size(); i++) {
//				if (c.getGuarantee().get(i).getPropertyTipe().getValue() == PropertyType.MINDELAY_VALUE) {
//					cont = cont + " " + "(= " + c.getModule().getName() + ".mindelay "
//							+ c.getGuarantee().get(i).getProperty() + ")";
//				} else if (c.getGuarantee().get(i).getPropertyTipe().getValue() == PropertyType.MAXDELAY_VALUE) {
//					cont = cont + " " + "(= " + c.getModule().getName() + ".maxdelay "
//							+ c.getGuarantee().get(i).getProperty() + ")";
//				} else {
//					cont = cont + " " + this.gs.parseString(this.replacePortsTiming(c.getGuarantee().get(i)));
//				}
//			}
//			cont = cont + ")";
//
//		}
//		cont = cont + "))";
//		return cont;
//
//	}
//
//	String getTimingFuncStringofContract(Contract c) {
//		String cont = new String("(define-fun ValidContract () Bool (=> ");
//		if (c.getAssumption().size() == 0) {
//			cont = cont + "true ";
//
//		} else if (c.getAssumption().size() == 1) {
//			cont = cont + this.gs.parseString(this.replacePortsTiming(c.getAssumption().get(0)));
//
//		} else {
//			cont = cont + "(and";
//			for (int i = 0; i < c.getAssumption().size(); i++) {
//				cont = cont + " " + this.gs.parseString(this.replacePortsTiming(c.getAssumption().get(i)));
//
//			}
//			cont = cont + ")";
//
//		}
//		if (c.getGuarantee().size() == 0) {
//			cont = cont + "true ";
//
//		} else if (c.getGuarantee().size() == 1) {
//			cont = cont + this.gs.parseString(this.replacePortsTiming(c.getGuarantee().get(0)));
//
//		} else {
//			cont = cont + "(and";
//			for (int i = 0; i < c.getGuarantee().size(); i++) {
//				if (c.getGuarantee().get(i).getPropertyTipe().getValue() == PropertyType.MINDELAY_VALUE) {
//					cont = cont + " " + "(>= " + c.getModule().getName() + ".mindelay "
//							+ c.getGuarantee().get(i).getProperty() + ")";
//				} else if (c.getGuarantee().get(i).getPropertyTipe().getValue() == PropertyType.MAXDELAY_VALUE) {
//					cont = cont + " " + "(<= " + c.getModule().getName() + ".maxdelay "
//							+ c.getGuarantee().get(i).getProperty() + ")";
//				} else {
//					cont = cont + " " + this.gs.parseString(this.replacePortsTiming(c.getGuarantee().get(i)));
//				}
//			}
//			cont = cont + ")";
//
//		}
//		cont = cont + "))";
//		cont = cont + "(assert (not ValidContract))";
//		return cont;
//
//	}
//
//	String replacePortsTiming(ContractProperty p) {
//		String prop = new String();
//		if (p instanceof Assumption) {
//			Assumption a = (Assumption) p;
//			Module m = a.getContract().getModule();
//			String append = new String();
//			prop = a.getProperty();
//			switch (a.getPropertyTipe().getValue()) {
//			case PropertyType.MINDURATION_VALUE:
//				append = new String("minduration");
//				break;
//			case PropertyType.FREQUENCY_VALUE:
//				append = new String("frequency");
//				break;
//			case PropertyType.JITTER_VALUE:
//				append = new String("jitter");
//				break;
//			case PropertyType.MAXDURATION_VALUE:
//				append = new String("maxduration");
//				break;
//			}
//			for (Ports port : m.getPorts()) {
//				prop = prop.replaceAll(
//						"(^)" + port.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + port.getName()
//								+ "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + port.getName() + "($)",
//						"$1$3$5" + m.getName() + "." + port.getName() + "." + append + "$2$4$6");
//				prop = prop.replaceAll(
//						"(^)" + port.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + port.getName()
//								+ "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + port.getName() + "($)",
//						"$1$3$5" + m.getName() + "." + port.getName() + "." + append + "$2$4$6");
//			}
//
//		} else if (p instanceof Guarantee) {
//			Guarantee a = (Guarantee) p;
//			Module m = a.getContract().getModule();
//
//			String append = new String();
//			prop = a.getProperty();
//			switch (a.getPropertyTipe().getValue()) {
//			case PropertyType.MINDURATION_VALUE:
//				append = new String("minduration");
//				break;
//			case PropertyType.FREQUENCY_VALUE:
//				append = new String("frequency");
//				break;
//			case PropertyType.JITTER_VALUE:
//				append = new String("jitter");
//				break;
//			case PropertyType.MAXDURATION_VALUE:
//				append = new String("maxduration");
//				break;
//			}
//			for (Ports port : m.getPorts()) {
//				prop = prop.replaceAll(
//						"(^)" + port.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + port.getName()
//								+ "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + port.getName() + "($)",
//						"$1$3$5" + m.getName() + "." + port.getName() + "." + append + "$2$4$6");
//				prop = prop.replaceAll(
//						"(^)" + port.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + port.getName()
//								+ "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + port.getName() + "($)",
//						"$1$3$5" + m.getName() + "." + port.getName() + "." + append + "$2$4$6");
//
//			}
//
//		}
//		return prop;
//	}
//
//}
