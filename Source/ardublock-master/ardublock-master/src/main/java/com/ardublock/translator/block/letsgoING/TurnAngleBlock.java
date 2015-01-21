package com.ardublock.translator.block.letsgoING;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class TurnAngleBlock extends TranslatorBlock
{

  public TurnAngleBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
  {
    super(blockId, translator, codePrefix, codeSuffix, label);
  }

  public String toCode() throws SocketNullException, SubroutineNotDeclaredException
  {
    String angle, speed, direction, ret;
        
    // Wert von dem ersten Blockeingang auslesen
    TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
    angle = translatorBlock.toCode();
    
    translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
    speed = translatorBlock.toCode();
    
    translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
    direction = translatorBlock.toCode();
           
    // Header hinzuf�gen
    translator.addHeaderFile("letsgoING_Drive.h");
            
    // Deklarationen hinzuf�gen
	translator.addDefinitionCommand("Drive Rover;");
	
          
    // Code von der Mainfunktion
    ret = "Rover.turnAngle(" + angle + "," +speed + "," +direction + ");\n";
   
    return codePrefix + ret + codeSuffix;
  }
}
