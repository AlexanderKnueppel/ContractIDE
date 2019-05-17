package de.tu_bs.ccc.contracting.core.verification.solver;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.eclipse.ui.testing.TestableObject;

import de.tu_bs.ccc.contracting.Verification.Assumption;
import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Guarantee;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.MmFactory;

public class SMTSolver {
	public static void main(String[] args) {
		SMTSolver smt = new SMTSolver();
		smt.test();
	}

	private void test() {

		for (int height = 1; height < 1001; height++) {
			
			for (int width = 4; width < 5; width++) {
				System.out.print("("+height+","+width);
				Compound c = MmFactory.eINSTANCE.createCompound();

				c.setName("Test");
				
				Contract c11 = MmFactory.eINSTANCE.createContract();
				Contract c22 = MmFactory.eINSTANCE.createContract();

				for (int j = 0; j < height; j++) {
					Ports p11 = MmFactory.eINSTANCE.createPorts();
					Ports p22 = MmFactory.eINSTANCE.createPorts();
					p11.setName("port1" + j);
					p22.setName("port2" + j);
					c.getPorts().add(p11);
					c.getPorts().add(p22);
					Assumption a11 = MmFactory.eINSTANCE.createAssumption();
					Assumption a22 = MmFactory.eINSTANCE.createAssumption();
					Guarantee g11 = MmFactory.eINSTANCE.createGuarantee();
					Guarantee g22 = MmFactory.eINSTANCE.createGuarantee();
					a11.setProperty("port1"+j+"<<10");
					a22.setProperty("port1"+j+"<<5");
					g11.setProperty("port2"+j+"<<10");
					g22.setProperty("port2"+j+"<<5");
					c11.getAssumption().add(a11);
					c22.getAssumption().add(a22);
					c11.getGuarantee().add(g11);
					c22.getGuarantee().add(g22);
					
					

					for (int i = 0; i < width; i++) {
						Component com = MmFactory.eINSTANCE.createComponent();
						com.setName("Sub" + i +"w"+ j);
						Ports p1 = MmFactory.eINSTANCE.createPorts();
						Ports p2 = MmFactory.eINSTANCE.createPorts();
						p1.setName("port1");
						p2.setName("port2");
						com.getPorts().add(p1);
						com.getPorts().add(p2);
						
						Contract c1 = MmFactory.eINSTANCE.createContract();
						Contract c2 = MmFactory.eINSTANCE.createContract();
						Assumption a1 = MmFactory.eINSTANCE.createAssumption();
						Assumption a2 = MmFactory.eINSTANCE.createAssumption();
						Guarantee g1 = MmFactory.eINSTANCE.createGuarantee();
						Guarantee g2 = MmFactory.eINSTANCE.createGuarantee();
						a1.setProperty("port1<<10");
						a2.setProperty("port1<<5");
						g1.setProperty("port2<<10");
						g2.setProperty("port2<<5");
						c1.getAssumption().add(a1);
						c2.getAssumption().add(a2);
						c1.getGuarantee().add(g1);
						c2.getGuarantee().add(g2);
						com.getContract().add(c1);
						com.getContract().add(c2);
						com.setIsPartOf(c);

					}
				}
				for (int j = 0; j < height; j++) {
					for (int i = 0; i < width; i++) {
						if (i == 0) {
							Module m = c.getConsistsOf().get(j * width + i);
							m.getPorts().get(0);
							c.getPorts().get(j * 2);
							m.getPorts().get(0).setInsidePortseOpposite(c.getPorts().get(j * 2));

						} else {
							Module m = c.getConsistsOf().get(j * width + i);
							Module m2 = c.getConsistsOf().get(j * width + (i - 1));
							m.getPorts().get(0).setPortseOpposite(m2.getPorts().get(1));
							;

						}
						if (i == (width - 1)) {
							Module m = c.getConsistsOf().get(j * width + i);
							m.getPorts().get(1).getInsidePorts().add((c.getPorts().get((j * 2) + 1)));

						} else {
							Module m = c.getConsistsOf().get(j * width + i);
							Module m2 = c.getConsistsOf().get(j * width + (i + 1));
							m.getPorts().get(1).setPortseOpposite(m2.getPorts().get(0));
							;
						}
					}
				}
				
				CompoundSolver solver = new CompoundSolver(c);
				solver.checkCompound();
				long elapsedTime =0;
				List<MemoryPoolMXBean> pools = ManagementFactory.getMemoryPoolMXBeans();
				long total = 0;
				
				for (int i = 0; i < 10; i++) {
					long startTime = System.currentTimeMillis();
					boolean x = solver.checkCompound();
					long stopTime = System.currentTimeMillis();
					elapsedTime += stopTime - startTime;
					if (!x) {
						System.out.println("Fehler");
					}
				}
				
				for (MemoryPoolMXBean memoryPoolMXBean : pools)
				{
				  if (memoryPoolMXBean.getType() == MemoryType.HEAP)
				  {
				    long peakUsed = memoryPoolMXBean.getPeakUsage().getUsed();
				    total = total + peakUsed;
				  }
				} System.out.println(","+elapsedTime+")");

			}
			
			
		}

	}
}
