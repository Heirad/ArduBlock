package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class AndroidRemoteBlock extends TranslatorBlock
{
	public AndroidRemoteBlock(Long blockId, Translator translator, String codePrefix,	String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

//diese Zeile ersetzen durch void serialEvent()
	//private final static String ultraSonicFunction = "int UltraschallSensor(int SensorPin){\n long duration, cm; \n pinMode(SensorPin, OUTPUT); \n digitalWrite(SensorPin, LOW);  \n delayMicroseconds(2); \n digitalWrite(SensorPin, HIGH); \n delayMicroseconds(5); \n digitalWrite(SensorPin, LOW); \n pinMode(SensorPin, INPUT); \n duration = pulseIn(SensorPin, HIGH); \n cm =  duration / 29 / 2; \n return cm;\n }\n";
	private final static String serialEventFunction = " Ardudroid Remote;\n void serialEvent(){\n while(Serial.available()) \n { \n Remote.readBluetooth();  \n } \n Remote.getData();\n }\n";
	
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
	//String btVersion;
	//	String SensorPin;
	//	String echoPin;
	//	TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
	//	btVersion = translatorBlock.toCode();
		//translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		//echoPin = translatorBlock.toCode();
		
		
		
		 // Header hinzuf�gen
		translator.addHeaderFile("letsgoING_Ardudroid.h");
		
		// Deklarationen hinzuf�gen
		translator.addDefinitionCommand(serialEventFunction);
		
		// setup hinzuf�gen
	
		
		 translator.addSetupCommand("Remote.BTbee_begin(9600);");
		//translator.addSetupCommand("Remote.BTserial_begin();");
		
		// loop hinzuf�gen
		String ret = "";
			return codePrefix + ret + codeSuffix;
	}
	
}