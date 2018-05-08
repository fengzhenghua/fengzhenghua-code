package com.arthur.po;

import com.arthur.base.BaseMessagePo;
import com.arthur.base.Voice;

public class VoiceMessagePo extends BaseMessagePo{

	
	private static final long serialVersionUID = 9065767924231448985L;
	
	private Voice voice ;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}
	
	
}
