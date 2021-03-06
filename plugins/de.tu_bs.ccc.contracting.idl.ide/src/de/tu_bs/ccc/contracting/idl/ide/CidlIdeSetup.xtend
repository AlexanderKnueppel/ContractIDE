/*
 * generated by Xtext 2.15.0
 */
package de.tu_bs.ccc.contracting.idl.ide

import com.google.inject.Guice
import de.tu_bs.ccc.contracting.idl.CidlRuntimeModule
import de.tu_bs.ccc.contracting.idl.CidlStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class CidlIdeSetup extends CidlStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new CidlRuntimeModule, new CidlIdeModule))
	}
	
}
