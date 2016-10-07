package eu.mszulc.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import eu.mszulc.model.UserDao;

import javax.annotation.PostConstruct;

@SpringView(name = AnotherViewInAWall.VIEW_NAME)
    public class AnotherViewInAWall extends VerticalLayout implements View {
        public static final String VIEW_NAME = "view";

        @PostConstruct
        void init() {
            setMargin(true);
            setSpacing(true);
            addComponent(new Label("This is a view scoped view"));
        }

        @Override
        public void enter(ViewChangeListener.ViewChangeEvent event) {
            // the view is constructed in the init() method()
        }
    }
