package solver;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.URI;

import com.microsoft.z3.Context;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Status;
import com.microsoft.z3.Symbol;

import de.tu_bs.ccc.contracting.Verification.Assumption;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.ContractProperty;
import de.tu_bs.ccc.contracting.Verification.Guarantee;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.PropertyType;
import de.tu_bs.ccc.contracting.Verification.ViewPoint;
import de.tu_bs.ccc.contracting.core.grammar.GrammarSolver;
import general.LogWriter;

public class CompoundSolver {

	Compound m;
	Context ctx;
	GrammarSolver gs;

	public CompoundSolver(Compound m) {

		this.m = m;
		this.ctx = new Context();
		this.gs = new GrammarSolver();
	}

	public boolean checkCompound() {
		boolean checked = true;
		for (Module c : m.getConsitsOf()) {
			if (c.getModule() instanceof Compound) {
				CompoundSolver s = new CompoundSolver((Compound) c.getModule());
				if (!s.checkCompound()) {
					checked = false;
				}
			}

		}
		if (!(checkTiming() && checkFunctional() && checkMemory())) {
			checked = false;
		}
		return checked;
	}

	private boolean checkFunctional() {
		boolean contractsMet = true;
		ArrayList<Ports> p = new ArrayList<Ports>();
		for (Module mod : this.m.getConsitsOf()) {
			for (Ports port : mod.getPorts()) {
				p.add(port);
			}
		}
		for (Ports port : this.m.getPorts()) {
			p.add(port);
		}

		Symbol[] declNames = new Symbol[p.size()];
		FuncDecl[] decl = new FuncDecl[p.size()];
		for (int i = 0; i < decl.length; i++) {
			declNames[i] = this.ctx.mkSymbol(p.get(i).getModule().getName() + "." + p.get(i).getName());
			switch (p.get(i).getType().getValue()) {

			case PortType.BOOLEAN_VALUE:
				decl[i] = this.ctx.mkConstDecl(declNames[i], ctx.mkBoolSort());
				break;
			case PortType.REAL_VALUE:
				decl[i] = this.ctx.mkConstDecl(declNames[i], ctx.mkRealSort());
				break;
			case PortType.STRING_VALUE:
				decl[i] = this.ctx.mkConstDecl(declNames[i], ctx.mkStringSort());
				break;

			default:
				decl[i] = this.ctx.mkConstDecl(declNames[i], ctx.mkIntSort());
				break;

			}

		}
		Solver solver = this.ctx.mkSolver();
		for (Ports port : p) {
			for (Ports oppositePort : port.getPorts()) {
				solver.add(this.ctx.parseSMTLIB2String(
						"(assert (" + "= " + port.getModule().getName() + "." + port.getName() + " "
								+ oppositePort.getModule().getName() + "." + oppositePort.getName() + "))",
						null, null, declNames, decl));

			}
			for (Ports endport : port.getInsidePorts()) {
				if (endport.getModule().getName().equals(this.m.getName())) {

					solver.add(this.ctx.parseSMTLIB2String(
							"(assert (" + "= " + endport.getModule().getName() + "." + endport.getName() + " "
									+ port.getModule().getName() + "." + port.getName() + "))",
							null, null, declNames, decl));

				}
			}
		}
		for (Ports port : this.m.getPorts()) {
			for (Ports oppositePort : port.getInsidePorts()) {
				solver.add(this.ctx.parseSMTLIB2String(
						"(assert (" + "= " + port.getModule().getName() + "." + port.getName() + " "
								+ oppositePort.getModule().getName() + "." + oppositePort.getName() + "))",
						null, null, declNames, decl));

			}

		}
		for (Module component : this.m.getConsitsOf()) {
			for (Contract c : component.getContract()) {
				if (c.getViewPoint().getValue() == ViewPoint.FUNCTIONAL_VALUE) {
					try {
						solver.add(
								this.ctx.parseSMTLIB2String(this.getStringofContract(c), null, null, declNames, decl));
					} catch (Exception e) {
						String x = "Error caused by: " + c.getModule().getName() + " " + c.getViewPoint();
						JOptionPane.showMessageDialog(null, x, "Contract Parsing Error", JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		}
		for (Contract con : this.m.getContract()) {
			if (con.getViewPoint().getValue() == ViewPoint.FUNCTIONAL_VALUE) {
				solver.push();
				try {
					solver.add(this.ctx.parseSMTLIB2String(this.getStringFuncofContract(con), null, null, declNames,
							decl));
				} catch (Exception e) {
					String x = "Error caused by: " + con.getModule().getName() + " " + con.getViewPoint();
					JOptionPane.showMessageDialog(null, x, "Contract Parsing Error", JOptionPane.ERROR_MESSAGE);
				}
				if (solver.check() == Status.SATISFIABLE) {
					contractsMet = false;
					URI fileURI = this.m.eResource().getURI();
					fileURI = fileURI.trimFileExtension();

					LogWriter.writeLog(solver.getModel().toString(), fileURI.toString());
				}
				solver.pop();
			}
		}

		return contractsMet;
	}

	private boolean checkMemory() {
		boolean isVerified = true;
		Symbol[] declNames = new Symbol[this.m.getConsitsOf().size() + 1];
		FuncDecl[] decl = new FuncDecl[this.m.getConsitsOf().size() + 1];
		declNames[0] = this.ctx.mkSymbol(this.m.getName() + ".Memory");
		decl[0] = this.ctx.mkConstDecl(declNames[0], ctx.mkRealSort());
		for (int i = 1; i < this.m.getConsitsOf().size() + 1; i++) {
			declNames[i] = this.ctx.mkSymbol(this.m.getConsitsOf().get(i - 1).getName() + ".Memory");
			decl[i] = this.ctx.mkConstDecl(declNames[i], ctx.mkRealSort());

		}

		Solver s = this.ctx.mkSolver();
		for (Module mod : this.m.getConsitsOf()) {
			for (Contract cont : mod.getContract()) {
				if (cont.getViewPoint().getValue() == ViewPoint.MEMORY_VALUE) {
					String inter = cont.getGuarantee().get(0).getProperty().replaceAll("Memory",
							mod.getName() + ".Memory");
					inter = this.gs.parseString(inter);
					s.add(ctx.parseSMTLIB2String("(assert " + inter + ")", null, null, declNames, decl));
				}
			}

		}
		for (Contract cont : this.m.getContract()) {
			if (cont.getViewPoint().getValue() == ViewPoint.MEMORY_VALUE) {
				String guarantee = cont.getGuarantee().get(0).getProperty().replaceAll("Memory",
						this.m.getName() + ".Memory");
				guarantee = this.gs.parseString(guarantee);
				String assumption = new String();
				for (Module mod : this.m.getConsitsOf()) {

					assumption = assumption + " " + mod.getName() + ".Memory";

				}

				if (this.m.getConsitsOf().size() == 0) {

				} else if (this.m.getConsitsOf().size() == 1) {
					s.add(ctx.parseSMTLIB2String(
							"(define-fun ValidContract () Bool (=> " + "(= " + this.m.getName() + ".Memory " + ""
									+ assumption + ") " + guarantee + "))(assert (not ValidContract))",
							null, null, declNames, decl));
				}

				else {

					s.add(ctx.parseSMTLIB2String(
							"(define-fun ValidContract () Bool (=> " + "(= " + this.m.getName() + ".Memory " + "(+"
									+ assumption + "))" + " " + guarantee + "))(assert (not ValidContract))",
							null, null, declNames, decl));
				}

				if (s.check() == Status.SATISFIABLE) {

					isVerified = false;
					URI fileURI = this.m.eResource().getURI();
					fileURI = fileURI.trimFileExtension();

					LogWriter.writeLog(s.getModel().toString(), fileURI.toString());
				}
			}

		}

		return isVerified;

	}

	private boolean checkTiming() {
		boolean contractsMet = true;

		ArrayList<Ports> p = new ArrayList<Ports>();
		for (Module mod : this.m.getConsitsOf()) {
			for (Ports port : mod.getPorts()) {
				p.add(port);
			}
		}
		for (Ports port : this.m.getPorts()) {
			p.add(port);
		}
		Symbol[] declNames = new Symbol[(p.size() * 6) + ((this.m.getConsitsOf().size()) * 4)];
		FuncDecl[] decl = new FuncDecl[(p.size() * 6) + ((this.m.getConsitsOf().size()) * 4)];
		for (int i = 0; i < p.size(); i++) {
			declNames[i * 6] = this.ctx
					.mkSymbol(p.get(i).getModule().getName() + "." + p.get(i).getName() + "." + "minduration");
			declNames[(i * 6) + 1] = this.ctx
					.mkSymbol(p.get(i).getModule().getName() + "." + p.get(i).getName() + "." + "maxduration");
			declNames[(i * 6) + 2] = this.ctx
					.mkSymbol(p.get(i).getModule().getName() + "." + p.get(i).getName() + "." + "frequency");
			declNames[(i * 6) + 3] = this.ctx
					.mkSymbol(p.get(i).getModule().getName() + "." + p.get(i).getName() + "." + "jitter");
			declNames[(i * 6) + 4] = this.ctx
					.mkSymbol(p.get(i).getModule().getName() + "." + p.get(i).getName() + "." + "mindelay");
			declNames[(i * 6) + 5] = this.ctx
					.mkSymbol(p.get(i).getModule().getName() + "." + p.get(i).getName() + "." + "maxdelay");
			decl[i * 6] = this.ctx.mkConstDecl(declNames[i * 6], ctx.mkRealSort());
			decl[(i * 6) + 1] = this.ctx.mkConstDecl(declNames[(i * 6) + 1], ctx.mkRealSort());
			decl[(i * 6) + 2] = this.ctx.mkConstDecl(declNames[(i * 6) + 2], ctx.mkRealSort());
			decl[(i * 6) + 3] = this.ctx.mkConstDecl(declNames[(i * 6) + 3], ctx.mkRealSort());
			decl[(i * 6) + 4] = this.ctx.mkConstDecl(declNames[(i * 6) + 4], ctx.mkRealSort());
			decl[(i * 6) + 5] = this.ctx.mkConstDecl(declNames[(i * 6) + 5], ctx.mkRealSort());

		}
		for (int i = 0; i < this.m.getConsitsOf().size(); i++) {
			declNames[(p.size() * 6) + i * 4] = this.ctx
					.mkSymbol(this.m.getConsitsOf().get(i).getName() + ".inMindelay");
			decl[(p.size() * 6) + i * 4] = this.ctx.mkConstDecl(declNames[(p.size() * 6) + (i * 4)], ctx.mkRealSort());
			declNames[(p.size() * 6) + 1 + (i * 4)] = this.ctx
					.mkSymbol(this.m.getConsitsOf().get(i).getName() + ".inMaxdelay");
			decl[(p.size() * 6) + 1 + (i * 4)] = this.ctx.mkConstDecl(declNames[(p.size() * 6) + (i * 4) + 1],
					ctx.mkRealSort());
			declNames[(p.size() * 6) + 2 + (i * 4)] = this.ctx
					.mkSymbol(this.m.getConsitsOf().get(i).getName() + ".outMindelay");
			decl[(p.size() * 6) + 2 + (i * 4)] = this.ctx.mkConstDecl(declNames[(p.size() * 6) + (i * 4) + 2],
					ctx.mkRealSort());
			declNames[(p.size() * 6) + 3 + (i * 4)] = this.ctx
					.mkSymbol(this.m.getConsitsOf().get(i).getName() + ".outMaxdelay");
			decl[(p.size() * 6) + 3 + (i * 4)] = this.ctx.mkConstDecl(declNames[(p.size() * 6) + (i * 4) + 3],
					ctx.mkRealSort());

		}

		Solver solver = this.ctx.mkSolver();
		String[] ending = { ".minduration", ".maxduration", ".mindelay", ".maxdelay", ".frequency", ".jitter" };

		for (int i = 0; i < p.size(); i++) {
			for (String string : ending) {

				for (Ports endport : p.get(i).getPorts()) {

					solver.add(this.ctx.parseSMTLIB2String(
							"(assert (" + "= " + endport.getModule().getName() + "." + endport.getName() + string + " "
									+ p.get(i).getModule().getName() + "." + p.get(i).getName() + string + "))",
							null, null, declNames, decl));

				}
				for (Ports endport : p.get(i).getInsidePorts()) {
					if (endport.getModule().getName().equals(this.m.getName())) {
						// System.out.println("(assert (" + "= " + endport.getModule().getName() + "." +
						// endport.getName()
						// + string + " " + p.get(i).getModule().getName() + "." + p.get(i).getName() +
						// string
						// + "))");
						solver.add(this.ctx.parseSMTLIB2String("(assert (" + "= " + endport.getModule().getName() + "."
								+ endport.getName() + string + " " + p.get(i).getModule().getName() + "."
								+ p.get(i).getName() + string + "))", null, null, declNames, decl));

					}

				}
			}
		}

		for (Ports inputModule : this.m.getPorts()) {
			for (Ports endport : inputModule.getInsidePorts()) {
				for (String string : ending) {
					solver.add(this.ctx.parseSMTLIB2String(
							"(assert (" + "= " + endport.getModule().getName() + "." + endport.getName() + string + " "
									+ inputModule.getModule().getName() + "." + inputModule.getName() + string + "))",
							null, null, declNames, decl));
				}
			}
		}
		for (Module part : this.m.getConsitsOf()) {

			ArrayList<Ports> inputPorts = this.getInputportOfModule(part);
			if (inputPorts.size() == 0 || inputPorts == null) {
				solver.add(this.ctx.parseSMTLIB2String("(assert (= " + part.getName() + ".inMindelay" + " 0" + "))",
						null, null, declNames, decl));
				solver.add(this.ctx.parseSMTLIB2String("(assert (= " + part.getName() + ".inMaxdelay" + " 0" + "))",
						null, null, declNames, decl));

			}

			else if (inputPorts.size() == 1) {
				solver.add(this.ctx.parseSMTLIB2String(
						"(assert (= " + part.getName() + ".inMindelay " + inputPorts.get(0).getModule().getName() + "."
								+ inputPorts.get(0).getName() + ".mindelay" + "))",
						null, null, declNames, decl));
				solver.add(this.ctx.parseSMTLIB2String(
						"(assert (= " + part.getName() + ".inMaxdelay " + inputPorts.get(0).getModule().getName() + "."
								+ inputPorts.get(0).getName() + ".maxdelay" + "))",
						null, null, declNames, decl));

			} else if (inputPorts.size() == 2) {

				solver.add(this.ctx.parseSMTLIB2String("(assert (=> (>= " + inputPorts.get(1).getModule().getName()
						+ "." + inputPorts.get(1).getName() + ".mindelay" + " "
						+ inputPorts.get(0).getModule().getName() + "." + inputPorts.get(0).getName() + ".mindelay)"
						+ " (= " + part.getName() + ".inMindelay " + inputPorts.get(1).getModule().getName() + "."
						+ inputPorts.get(1).getName() + ".mindelay" + ")))", null, null, declNames, decl));
				solver.add(this.ctx.parseSMTLIB2String("(assert (=> (>= " + inputPorts.get(0).getModule().getName()
						+ "." + inputPorts.get(0).getName() + ".mindelay" + " "
						+ inputPorts.get(1).getModule().getName() + "." + inputPorts.get(1).getName() + ".mindelay)"
						+ " (= " + part.getName() + ".inMindelay " + inputPorts.get(0).getModule().getName() + "."
						+ inputPorts.get(0).getName() + ".mindelay" + ")))", null, null, declNames, decl));
				solver.add(this.ctx.parseSMTLIB2String("(assert (=> (>= " + inputPorts.get(1).getModule().getName()
						+ "." + inputPorts.get(1).getName() + ".maxdelay" + " "
						+ inputPorts.get(0).getModule().getName() + "." + inputPorts.get(0).getName() + ".maxdelay)"
						+ " (= " + part.getName() + ".inMaxdelay " + inputPorts.get(1).getModule().getName() + "."
						+ inputPorts.get(1).getName() + ".maxdelay" + ")))", null, null, declNames, decl));
				solver.add(this.ctx.parseSMTLIB2String("(assert (=> (>= " + inputPorts.get(0).getModule().getName()
						+ "." + inputPorts.get(0).getName() + ".maxdelay" + " "
						+ inputPorts.get(1).getModule().getName() + "." + inputPorts.get(1).getName() + ".maxdelay)"
						+ " (= " + part.getName() + ".inMaxdelay " + inputPorts.get(0).getModule().getName() + "."
						+ inputPorts.get(0).getName() + ".maxdelay" + ")))", null, null, declNames, decl));
			} else {
				for (int j = 0; j < inputPorts.size(); j++) {
					String check1 = "(assert (=> (and ";
					String check2 = "(assert (=> (and ";

					for (int i = 0; i < inputPorts.size(); i++) {
						if (i != j) {
							check1 = check1 + "(>= " + inputPorts.get(j).getModule().getName() + "."
									+ inputPorts.get(j).getName() + ".mindelay" + " "
									+ inputPorts.get(i).getModule().getName() + "." + inputPorts.get(i).getName()
									+ ".mindelay)";
							check2 = check2 + "(>= " + inputPorts.get(j).getModule().getName() + "."
									+ inputPorts.get(j).getName() + ".maxdelay" + " "
									+ inputPorts.get(i).getModule().getName() + "." + inputPorts.get(i).getName()
									+ ".maxdelay)";
						}

					}
					check1 = check1 + ")(= " + part.getName() + ".inMindelay " + inputPorts.get(j).getModule().getName()
							+ "." + inputPorts.get(j).getName() + ".mindelay" + ")))";
					check2 = check2 + ")(= " + part.getName() + ".inMaxdelay " + inputPorts.get(j).getModule().getName()
							+ "." + inputPorts.get(j).getName() + ".maxdelay" + ")))";
					// System.out.println(check1);
					// System.out.println(check2);
					solver.add(this.ctx.parseSMTLIB2String(check1, null, null, declNames, decl));
					solver.add(this.ctx.parseSMTLIB2String(check2, null, null, declNames, decl));
				}

			}
			ArrayList<Ports> output = this.getOutputportOfModule(part);
			for (Ports ports : output) {
				solver.add(this.ctx.parseSMTLIB2String(
						"(assert (= " + ports.getModule().getName() + "." + ports.getName() + ".maxdelay" + " " + "(+ "
								+ part.getName() + ".outMaxdelay " + part.getName() + ".inMaxdelay" + ")))",
						null, null, declNames, decl));
				solver.add(this.ctx.parseSMTLIB2String(
						"(assert (= " + ports.getModule().getName() + "." + ports.getName() + ".mindelay" + " " + "(+ "
								+ part.getName() + ".outMindelay " + part.getName() + ".inMindelay" + ")))",
						null, null, declNames, decl));
			}
			for (Contract c : part.getContract()) {
				if (c.getViewPoint().getValue() == ViewPoint.TIMING_VALUE) {
					// System.out.println(this.getTimingStringofContract(c));
					solver.add(this.ctx.parseSMTLIB2String(this.getTimingStringofContract(c), null, null, declNames,
							decl));
				}

			}

		}

		for (Contract con : this.m.getContract()) {
			if (con.getViewPoint().getValue() == ViewPoint.TIMING_VALUE) {
				solver.push();
				// System.out.println(this.getTimingFuncStringofContract(con));
				solver.add(

						this.ctx.parseSMTLIB2String(this.getTimingFuncStringofContract(con), null, null, declNames,
								decl));
				// System.out.println(solver);
				if (solver.check() == Status.SATISFIABLE) {
					contractsMet = false;
					URI fileURI = this.m.eResource().getURI();
					fileURI = fileURI.trimFileExtension();

					LogWriter.writeLog(solver.getModel().toString(), fileURI.toString());
				}
				solver.pop();

			}
		}
		return contractsMet;

	}

	String getStringofContract(Contract c) {
		String cont = new String("(assert(=> ");
		if (c.getAssumption().size() == 0) {
			cont = cont + "true ";

		} else if (c.getAssumption().size() == 1) {
			cont = cont + this.gs.parseString(c.getAssumption().get(0).getProperty());

		} else {
			cont = cont + "(and";
			for (int i = 0; i < c.getAssumption().size(); i++) {
				cont = cont + " " + this.gs.parseString(c.getAssumption().get(i).getProperty());

			}
			cont = cont + ")";

		}
		cont = cont + " ";
		if (c.getGuarantee().size() == 0) {
			cont = cont + "true ";

		} else if (c.getGuarantee().size() == 1) {
			cont = cont + this.gs.parseString(c.getGuarantee().get(0).getProperty());

		} else {
			cont = cont + "(and";
			for (int i = 0; i < c.getGuarantee().size(); i++) {
				cont = cont + " " + this.gs.parseString(c.getGuarantee().get(i).getProperty());

			}
			cont = cont + ")";

		}
		cont = cont + "))";
		cont = this.replacePortNamesFunc(cont, c.getModule());
		return cont;

	}

	String getStringFuncofContract(Contract c) {
		String cont = new String("(define-fun ValidContract () Bool (=> ");
		if (c.getAssumption().size() == 0) {
			cont = cont + "true ";

		} else if (c.getAssumption().size() == 1) {
			cont = cont + this.gs.parseString(c.getAssumption().get(0).getProperty());

		} else {
			cont = cont + "(and";
			for (int i = 0; i < c.getAssumption().size(); i++) {
				cont = cont + " " + this.gs.parseString(c.getAssumption().get(i).getProperty());

			}
			cont = cont + ")";

		}
		if (c.getGuarantee().size() == 0) {
			cont = cont + "true ";

		} else if (c.getGuarantee().size() == 1) {
			cont = cont + this.gs.parseString(c.getGuarantee().get(0).getProperty());

		} else {
			cont = cont + "(and";
			for (int i = 0; i < c.getGuarantee().size(); i++) {
				cont = cont + " " + this.gs.parseString(c.getGuarantee().get(i).getProperty());

			}
			cont = cont + ")";

		}
		cont = cont + "))";
		cont = this.replacePortNamesFunc(cont, c.getModule());
		cont = cont + "(assert (not ValidContract))";
		return cont;

	}

	String replacePortNamesFunc(String constraint, Module m) {
		for (Ports port : m.getPorts()) {
			constraint = constraint.replaceAll(
					"(^)" + port.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + port.getName()
							+ "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + port.getName() + "($)",
					"$1$3$5" + m.getName() + "." + port.getName() + "$2$4$6");
			constraint = constraint.replaceAll(
					"(^)" + port.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + port.getName()
							+ "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + port.getName() + "($)",
					"$1$3$5" + m.getName() + "." + port.getName() + "$2$4$6");
		}
		return constraint;

	}

	ArrayList<Ports> getInputportOfModule(Module m) {
		ArrayList<Ports> input = new ArrayList<Ports>();
		for (Ports ports : m.getPorts()) {
			if (ports.getPortseOpposite() != null) {
				input.add(ports);

			}

		}
		return input;

	}

	ArrayList<Ports> getOutputportOfModule(Module m) {
		ArrayList<Ports> input = new ArrayList<Ports>();
		for (Ports ports : m.getPorts()) {
			if (ports.getPorts().size() != 0) {
				input.add(ports);

			} else if (ports.getInsidePorts().size() != 0) {
				input.add(ports);
			}

		}
		return input;

	}

	String getTimingStringofContract(Contract c) {
		String cont = new String("(assert(=> ");
		if (c.getAssumption().size() == 0) {
			cont = cont + "true ";

		} else if (c.getAssumption().size() == 1) {
			cont = cont + this.gs.parseString(this.replacePortsTiming(c.getAssumption().get(0)));

		} else {
			cont = cont + "(and";
			for (int i = 0; i < c.getAssumption().size(); i++) {
				cont = cont + " " + this.gs.parseString(this.replacePortsTiming(c.getAssumption().get(i)));

			}
			cont = cont + ")";

		}
		if (c.getGuarantee().size() == 0) {
			cont = cont + "true ";

		} else if (c.getGuarantee().size() == 1) {
			if (c.getGuarantee().get(0).getPropertyTipe().getValue() == PropertyType.MINDELAY_VALUE) {
				cont = cont + " " + "(= " + c.getModule().getName() + ".outMindelay "
						+ c.getGuarantee().get(0).getProperty() + ")";
			} else if (c.getGuarantee().get(0).getPropertyTipe().getValue() == PropertyType.MAXDELAY_VALUE) {
				cont = cont + " " + "(= " + c.getModule().getName() + ".outMaxdelay "
						+ c.getGuarantee().get(0).getProperty() + ")";
			} else {
				cont = cont + " " + this.gs.parseString(this.replacePortsTiming(c.getGuarantee().get(0)));
			}

		} else {
			cont = cont + "(and";
			for (int i = 0; i < c.getGuarantee().size(); i++) {
				if (c.getGuarantee().get(i).getPropertyTipe().getValue() == PropertyType.MINDELAY_VALUE) {
					cont = cont + " " + "(= " + c.getModule().getName() + ".outMindelay "
							+ c.getGuarantee().get(i).getProperty() + ")";
				} else if (c.getGuarantee().get(i).getPropertyTipe().getValue() == PropertyType.MAXDELAY_VALUE) {
					cont = cont + " " + "(= " + c.getModule().getName() + ".outMaxdelay "
							+ c.getGuarantee().get(i).getProperty() + ")";
				} else {
					try {
						cont = cont + " " + this.gs.parseString(this.replacePortsTiming(c.getGuarantee().get(i)));
					} catch (Exception e) {
						System.out.println(
								c.getModule().getName() + "Timing contract Parsing Error" + c.getGuarantee().get(i));
					}

				}
			}
			cont = cont + ")";

		}
		cont = cont + "))";
		return cont;

	}

	String getTimingFuncStringofContract(Contract c) {
		String cont = new String("(define-fun ValidContract () Bool (=> ");
		if (c.getAssumption().size() == 0) {
			cont = cont + "true ";

		} else if (c.getAssumption().size() == 1) {
			cont = cont + this.gs.parseString(this.replacePortsTiming(c.getAssumption().get(0)));

		} else {
			cont = cont + "(and";
			for (int i = 0; i < c.getAssumption().size(); i++) {
				cont = cont + " " + this.gs.parseString(this.replacePortsTiming(c.getAssumption().get(i)));

			}
			cont = cont + ")";

		}
		cont = cont + " ";
		if (c.getGuarantee().size() == 0) {
			cont = cont + "true ";

		} else if (c.getGuarantee().size() == 1) {
			if (c.getGuarantee().get(0).getPropertyTipe().getValue() == PropertyType.MINDELAY_VALUE) {
				ArrayList<Ports> inputports = this.getInsideInputportOfModule(c.getModule());
				if (inputports.size() > 1) {
					cont = cont + "(and";
				}
				for (Ports ports : inputports) {

					cont = cont + " " + "(>= " + ports.getModule().getName() + "." + ports.getName() + ".mindelay "
							+ c.getGuarantee().get(0).getProperty() + ")";
				}
				if (inputports.size() > 1) {
					cont = cont + ")";
				}

			} else if (c.getGuarantee().get(0).getPropertyTipe().getValue() == PropertyType.MAXDELAY_VALUE) {
				ArrayList<Ports> inputports = this.getInsideInputportOfModule(c.getModule());
				if (inputports.size() > 1) {
					cont = cont + "(and";
				}
				for (Ports ports : inputports) {
					cont = cont + " " + "(<= " + ports.getModule().getName() + "." + ports.getName() + ".maxdelay "
							+ c.getGuarantee().get(0).getProperty() + ")";
				}
				if (inputports.size() > 1) {
					cont = cont + ")";
				}
			} else {
				cont = cont + " " + this.gs.parseString(this.replacePortsTiming(c.getGuarantee().get(0)));
			}

		} else {
			cont = cont + "(and";
			for (int i = 0; i < c.getGuarantee().size(); i++) {
				if (c.getGuarantee().get(i).getPropertyTipe().getValue() == PropertyType.MINDELAY_VALUE) {
					ArrayList<Ports> inputports = this.getInsideInputportOfModule(c.getModule());
					for (Ports ports : inputports) {
						cont = cont + " " + "(>= " + ports.getModule().getName() + "." + ports.getName() + ".mindelay "
								+ c.getGuarantee().get(i).getProperty() + ")";
					}

				} else if (c.getGuarantee().get(i).getPropertyTipe().getValue() == PropertyType.MAXDELAY_VALUE) {
					ArrayList<Ports> inputports = this.getInsideInputportOfModule(c.getModule());
					for (Ports ports : inputports) {
						cont = cont + " " + "(<= " + ports.getModule().getName() + "." + ports.getName() + ".maxdelay "
								+ c.getGuarantee().get(i).getProperty() + ")";
					}
				} else {
					cont = cont + " " + this.gs.parseString(this.replacePortsTiming(c.getGuarantee().get(i)));
				}
			}
			cont = cont + ")";

		}
		cont = cont + "))";
		cont = cont + "(assert (not ValidContract))";
		return cont;

	}

	String replacePortsTiming(ContractProperty p) {
		String prop = new String();
		if (p instanceof Assumption) {
			Assumption a = (Assumption) p;
			Module m = a.getContract().getModule();
			String append = new String();
			prop = a.getProperty();
			switch (a.getPropertyTipe().getValue()) {
			case PropertyType.MINDURATION_VALUE:
				append = new String("minduration");
				break;
			case PropertyType.FREQUENCY_VALUE:
				append = new String("frequency");
				break;
			case PropertyType.JITTER_VALUE:
				append = new String("jitter");
				break;
			case PropertyType.MAXDURATION_VALUE:
				append = new String("maxduration");
				break;
			}
			for (Ports port : m.getPorts()) {
				prop = prop.replaceAll(
						"(^)" + port.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + port.getName()
								+ "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + port.getName() + "($)",
						"$1$3$5" + m.getName() + "." + port.getName() + "." + append + "$2$4$6");
				prop = prop.replaceAll(
						"(^)" + port.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + port.getName()
								+ "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + port.getName() + "($)",
						"$1$3$5" + m.getName() + "." + port.getName() + "." + append + "$2$4$6");

			}

		} else if (p instanceof Guarantee) {
			Guarantee a = (Guarantee) p;
			Module m = a.getContract().getModule();

			String append = new String();
			prop = a.getProperty();
			switch (a.getPropertyTipe().getValue()) {
			case PropertyType.MINDURATION_VALUE:
				append = new String("minduration");
				break;
			case PropertyType.FREQUENCY_VALUE:
				append = new String("frequency");
				break;
			case PropertyType.JITTER_VALUE:
				append = new String("jitter");
				break;
			case PropertyType.MAXDURATION_VALUE:
				append = new String("maxduration");
				break;
			}
			for (Ports port : m.getPorts()) {
				prop = prop.replaceAll(
						"(^)" + port.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + port.getName()
								+ "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + port.getName() + "($)",
						"$1$3$5" + m.getName() + "." + port.getName() + "." + append + "$2$4$6");
				prop = prop.replaceAll(
						"(^)" + port.getName() + "([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])" + port.getName()
								+ "+([^a-zA-Z0-9.])" + "|([^a-zA-Z0-9.])+" + port.getName() + "($)",
						"$1$3$5" + m.getName() + "." + port.getName() + "." + append + "$2$4$6");

			}

		}
		return prop;
	}

	ArrayList<Ports> getInsideInputportOfModule(Module m) {
		ArrayList<Ports> input = new ArrayList<Ports>();
		for (Ports ports : m.getPorts()) {
			if (ports.getInsidePortseOpposite() != null) {
				input.add(ports);

			}

		}
		return input;

	}
}
