package eu.mszulc.controller;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class GreetMe {
    public String sayHello() {
        return "Hello from bean " + toString();
    }
}
