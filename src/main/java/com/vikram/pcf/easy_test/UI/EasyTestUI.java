/**
 * 
 */
package com.vikram.pcf.easy_test.UI;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.vikram.pcf.easy_test.service.EasyTestRestTemplate;

/**
 * @author traja
 *
 */
@SpringUI
public class EasyTestUI extends UI {

	private VerticalLayout root;

	@Autowired
	EasyTestRestTemplate restTeamplate;

	@Override
	protected void init(VaadinRequest request) {
		setUpLayout();
		addHeader();
		addTestFrom();
		// addResutlLayout();
		// addApplicaitonLayout();
	}

	private void addTestFrom() {

		HorizontalLayout vLayout = new HorizontalLayout();
		
		VerticalLayout lLayout=new VerticalLayout();
		lLayout.setWidth("50%");
		
		
		VerticalLayout rLayout=new VerticalLayout();
		rLayout.setWidth("50%");
		
		ComboBox<String> comboBox = new ComboBox<>();
		comboBox.setItems("GET", "POST");
		comboBox.setSelectedItem("GET");
		comboBox.addValueChangeListener(event -> {
			if (event.getSource().isEmpty()) {
				Notification.show("No Method Selected");
			}
		});
		comboBox.setWidth("100px");
		Label urlLabel=new Label("URL");
		TextField urlTestField = new TextField();
		//urlTestField.setCaption("URL");
		urlTestField.setWidth("350px");
		
		Button button = new Button("Send");
		//button.setCaption("Save");
		
		HorizontalLayout h1Layout = new HorizontalLayout();
		
		h1Layout.addComponent(comboBox);
		h1Layout.addComponent(urlLabel);
		h1Layout.addComponent(urlTestField);
		h1Layout.addComponent(button);
		
		rLayout.addComponent(h1Layout);

		Label headerLabel=new Label("Headers");
		Button addbutton=new Button("+");
		//addbutton.addClickListener(this::add )
		HorizontalLayout h4Layout=new HorizontalLayout();
		h4Layout.addComponent(headerLabel);
		h4Layout.addComponent(addbutton);
		TextField keyHeaderField = new TextField();
		keyHeaderField.setWidth("250px");
		TextField valueHeaderField = new TextField();
		valueHeaderField .setWidth("250px");
		HorizontalLayout h2Layout = new HorizontalLayout();
		h2Layout.addComponent(keyHeaderField);
		h2Layout.addComponent(valueHeaderField);
		rLayout.addComponent(h4Layout);
		rLayout.addComponent(h2Layout);

		HorizontalLayout h3Layout = new HorizontalLayout();
		TextArea requestArea = new TextArea();
		requestArea.setHeight("350px");
		requestArea.setWidth("550px");
		h3Layout.addComponent(requestArea);
		
		/*TextArea responseArea = new TextArea();
		resultTestArea.setHeight("450px");
		resultTestArea.setWidth("600px");
		h3Layout.addComponent(responseArea);*/
		rLayout.addComponent(h3Layout);
		vLayout.addComponent(lLayout);
		vLayout.addComponent(rLayout);
		
		TextField resultTestArea = new TextField();
		lLayout.addComponent(resultTestArea);
		resultTestArea.setHeight("450px");
		resultTestArea.setWidth("600px");
		root.addComponent(vLayout);

	}

	private void setUpLayout() {
		root = new VerticalLayout();
		
		setContent(root);
	}

	private void addHeader() {
		// Greeting helow = (Greeting)
		// restTeamplate.getRestResponseFor(Configuration.GREETING_URL, Greeting.class);
		Label header = new Label("EASY TEST");
		header.addStyleName(ValoTheme.LABEL_H1);
		header.setHeight("50px");
		
		root.addComponent(header);
		root.setStyleName(".valo.v-margin-bottom {" +" padding-bottom: 0px; " + "}");
		
	}

}
