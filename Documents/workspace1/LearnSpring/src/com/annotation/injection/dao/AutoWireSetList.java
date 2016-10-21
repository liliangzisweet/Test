/**
 * 
 */
package com.annotation.injection.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author liliangzi
 *
 */
@Component
public class AutoWireSetList {
	@Autowired
	private Set<InterfaceAutoWire> setInterface ;
	@Autowired
	private List<InterfaceAutoWire> listInterface;
	@Autowired
	private Map<String,InterfaceAutoWire> mapInterface;
	
	@Autowired
	@Qualifier("interfaceAutoWireImpl2")
	private InterfaceAutoWire interfaceauto;
	
	public void say(){
		System.out.println("This is set...");
		if(!setInterface.equals(null)&&!setInterface.isEmpty()){
			for(InterfaceAutoWire intf:setInterface){
				System.out.println(intf.getClass().getName());
			}
		}
		else{
			System.out.println("set is empty or null");
		}
		System.out.println("This is list...");
		if(!listInterface.equals(null)&&!listInterface.isEmpty()){
			for(InterfaceAutoWire intf:listInterface){
				System.out.println(intf.getClass().getName());
			}
		}
		else{
			System.out.println("list is empty or null");
		}
		System.out.println("This is map...");
		for(Map.Entry<String,InterfaceAutoWire> entry:mapInterface.entrySet()){
			System.out.println(entry.getKey()+" : "+entry.getValue().getClass().getName());
		}
		
		System.out.println("This is interfaceAutoWire");
		if(interfaceauto !=null){
			System.out.println(interfaceauto.getClass().getName());
		}
	}
	

}
