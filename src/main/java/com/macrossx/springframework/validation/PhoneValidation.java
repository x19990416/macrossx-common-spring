package com.macrossx.springframework.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * 手机号相关验证
 * @author starseeker.limin@gmail.com(X-Forever)
 */
@Getter
@Setter
@AllArgsConstructor
public class PhoneValidation {
	@NotNull(message="系统手机号不能为空")
	@NotEmpty(message="系统手机号不能为空")
	@Length(max=11,min=11,message="系统手机号长度必须为11位")
	@MatchPattern(pattern="^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9])|(14[0-9]))\\d{8}$",message="系统手机号格式错误,请输入正确的手机号")
	private String phoneNo;
	
}
