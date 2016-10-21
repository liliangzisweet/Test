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
@Order(1)
public class InterfaceAutoWireImpl2 implements InterfaceAutoWire {

}
