package org.mule.transport.cutome.transformers;

import java.net.MalformedURLException;
import java.net.URL;

import org.mule.api.annotations.ContainsTransformerMethods;
import org.mule.api.annotations.Transformer;

@ContainsTransformerMethods 
public class MyAnnotationTransformers {
	@Transformer
	  public URL stringToURL(String string) throws MalformedURLException
	  {
	      return new java.net.URL(string);
	  }
}
