package org.mule.transport.cutome.transformers;

import java.net.MalformedURLException;
import java.net.URL;

import org.mule.api.MuleMessage;
import org.mule.api.annotations.ContainsTransformerMethods;
import org.mule.api.annotations.Transformer;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.transformer.types.DataTypeFactory;

@ContainsTransformerMethods 
public class SemanticTranslator extends AbstractMessageTransformer{
	public SemanticTranslator() {
        registerSourceType(DataTypeFactory.STRING);
        setReturnDataType(DataTypeFactory.STRING);
        setName("SemanticTranslator");
    }
	@Transformer
	  public URL translate(String string) throws MalformedURLException
	  {
	      return new java.net.URL(string);
	  }
	@Override
	public Object transformMessage(MuleMessage arg0, String arg1)
			throws TransformerException {
		// TODO Auto-generated method stub
		return null;
	}
}
