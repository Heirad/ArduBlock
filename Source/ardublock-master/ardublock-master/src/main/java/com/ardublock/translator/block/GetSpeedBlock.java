package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class GetSpeedBlock extends TranslatorBlock
{
	public GetSpeedBlock(Long blockId, Translator translator, String codePrefix,	String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}


	
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
	
		
		// loop hinzuf�gen
		String ret = "Remote.getSpeed()";
		

		return codePrefix + ret + codeSuffix;
	}
	
}