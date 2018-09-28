package de.tu_bs.ccc.contracting.core.util;

import de.tu_bs.ccc.contracting.Verification.Module;

public abstract class ModuleFilter {
	public abstract boolean keep(Module m);
}
