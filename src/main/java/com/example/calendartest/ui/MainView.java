package com.example.calendartest.ui;

import com.example.calendartest.service.ContentService;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Route("")
public class MainView extends VerticalLayout {
	private static int maxLength = 10000;

	@Autowired
	public MainView(ContentService contentService) {
		setSizeFull();
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);

		// Add a label with the current time
		layout.add(new Label("Current time: " + new Date()));

		TextArea textArea = new TextArea();
		textArea.setLabel("Content getAll");
		textArea.setValueChangeMode(ValueChangeMode.EAGER);                                           
		textArea.setMaxLength(maxLength);
		textArea.setMinWidth(600.0f, Unit.PIXELS);
		textArea.addValueChangeListener(e -> {
			e.getSource()
				.setHelperText(e.getValue().length() + "/" + maxLength);
		});

		// Add a button that updates the time
		Button button = new Button("GET Content");
		button.addClickListener(e -> textArea.setValue(contentService.getPrettyContents()));
		layout.add(button);
		layout.add(textArea);
		add(layout);
	}
}
