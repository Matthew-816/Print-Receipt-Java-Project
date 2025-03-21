package io.guidemy;

import org.apache.commons.cli.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Hello world!
 *
 */
public class CurrencyConvertorMain {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        // create the command line parser
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        // create the Options

        Options options = createCommandLineOptions();

        CommandLine line = null;

        try {
            // parse the command line arguments
            line = parser.parse(options, args);

        } catch (ParseException exp) {
            System.out.println("Unexpected exception:" + exp.getMessage());
        }

        if (Objects.isNull(line)) {
            formatter.printHelp("Currency Convertor", options);
            System.exit(1);
        }

        String fromCurrency = line.getOptionValue("f");
        String toCurrency = line.getOptionValue("t");
        BigDecimal originalAmount = new BigDecimal(line.getOptionValue("a"));
        String inputFilePath = line.getOptionValue("i");

        ExchangeRateExtractor extractor = new ExchangeRateExtractor();
        ExchangeRateConvertor convertor = new ExchangeRateConvertor();
        PrincipalCalculator calculator = new PrincipalCalculator();
        CurrencyConvertorOrchestrator orchestrator = new CurrencyConvertorOrchestrator(
                convertor, extractor, calculator);
        ResultPrinter printer = new ResultPrinter();

        BigDecimal resultPrincipal = orchestrator.process(fromCurrency, toCurrency, originalAmount, inputFilePath);
        ResultPrinter.print(fromCurrency, toCurrency, originalAmount, resultPrincipal);

    }

    private static Options createCommandLineOptions() {
        Options options = new Options();
        options.addRequiredOption("a", "amount", true, "amount");
        options.addRequiredOption("f", "from", true, "from currency");
        options.addRequiredOption("i", "input", true, "input file path");
        options.addRequiredOption("t", "to", true, "to currency");
        return options;
    }
}
