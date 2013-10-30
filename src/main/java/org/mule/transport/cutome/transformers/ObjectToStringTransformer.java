package org.mule.transport.cutome.transformers;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.transformer.types.DataTypeFactory;

public class ObjectToStringTransformer extends AbstractMessageTransformer{
	
	 public ObjectToStringTransformer() {
	        registerSourceType(DataTypeFactory.create(ObjectToStringTransformer.class));
	        setReturnDataType(DataTypeFactory.STRING);
	        setName("OrderToHTML");
	    }

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		// TODO Auto-generated method stub
		 Object order = (Object)message.getPayload();
		 
		 return order.toString();
	}


}
