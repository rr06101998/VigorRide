package com.vigorride.exception;

public abstract class AbstractPlatformResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID=7913984516707431902L;
	private final String globalisationMessageCode;
    private final String defaultUserMessage;
    private final Object[] defaultUserMessageArgs;
   
	public AbstractPlatformResourceNotFoundException(final String globalisationMessageCode, final String defaultUserMessage,
			final Object...  defaultUserMessageArgs) {
		super(defaultUserMessage);
		this.globalisationMessageCode = globalisationMessageCode;
		this.defaultUserMessage = defaultUserMessage;
		this.defaultUserMessageArgs = defaultUserMessageArgs;
	}
	
	public String getGlobalisationMessageCode() {
		return this.globalisationMessageCode;
	}
	public String getDefaultUserMessage() {
		return this.defaultUserMessage;
	}
	public Object[] getDefaultUserMessageArgs() {
		return this.defaultUserMessageArgs;
	}
	
    
    
}
