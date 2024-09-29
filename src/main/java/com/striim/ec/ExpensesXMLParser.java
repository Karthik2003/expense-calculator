package com.striim.ec;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExpensesXMLParser {
    public void expensesModelList(Path path) throws FileNotFoundException, XMLStreamException {

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(path.toFile()));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        List<ExpensesModel> expensesModelList = new ArrayList<>();
        String fXCurrency = null;
        String fxAmount = null;
        String fxDate = null;

        // iterator of events
        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            if (event.isStartElement()) {
                StartElement element = event.asStartElement();
                switch (element.getName().getLocalPart()) {
                    case "currency_type":
                        event = reader.nextEvent();
                        fXCurrency = event.asCharacters().getData();
                        break;
                    case "amount":
                        event = reader.nextEvent();
                        fxAmount = event.asCharacters().getData();
                        break;
                    case "date":
                        event = reader.nextEvent();
                        fxDate = event.asCharacters().getData();
                        break;
                }
            }

            if (event.isEndElement()) {
                EndElement endElement = event.asEndElement();
                if (endElement.getName().getLocalPart().equals("expense")) {
                    ExpensesModel expensesModel = new ExpensesModel();
                    expensesModel.setCurrencyType(Objects.requireNonNull(fXCurrency).strip());
                    expensesModel.setAmount(Double.valueOf(Objects.requireNonNull(fxAmount).strip()));
                    expensesModel.setDate(LocalDate.parse(Objects.requireNonNull(fxDate).strip(), dateFormatter));
                    expensesModelList.add(expensesModel);
                }
            }
        }

        ExpensesAggregator expensesAggregator = new ExpensesAggregator();
        expensesAggregator.showAggregatedExpense(expensesModelList);
    }
}
