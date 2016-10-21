/**
 * 
 */
package com.annotation.injection.dao;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author liliangzi
 *
 */
@Component
@Order(2)
public class InterfaceAutoWireImpl1 implements InterfaceAutoWire {

}
