/*
 * generated by Xtext 2.15.0
 */
package de.tu_bs.ccc.contracting.idl


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class CidlStandaloneSetup extends CidlStandaloneSetupGenerated {

	def static void doSetup() {
		new CidlStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
