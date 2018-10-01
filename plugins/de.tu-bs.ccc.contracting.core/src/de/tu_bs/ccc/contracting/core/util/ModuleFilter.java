package de.tu_bs.ccc.contracting.core.util;

import de.tu_bs.ccc.contracting.Verification.Module;

public interface ModuleFilter {
	public boolean keep(Module m);
}
