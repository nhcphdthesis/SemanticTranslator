package org.mule.transport.cutome.transformers;

import java.net.MalformedURLException;
import java.net.URL;

import org.mule.api.annotations.ContainsTransformerMethods;
import org.mule.api.annotations.Transformer;

@ContainsTransformerMethods 
public class SemanticTranslator {
	public SemanticTranslator() {
        registerSourceType(DataTypeFactory.create(ObjectToStringTransformer.class));
        setReturnDataType(DataTypeFactory.STRING);
        setName("SemanticTranslator");
    }
	@Transformer
	  public URL translate(String string) throws MalformedURLException
	  {
	      return new java.net.URL(string);
	  }
}
