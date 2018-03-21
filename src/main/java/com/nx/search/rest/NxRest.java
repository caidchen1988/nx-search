package com.nx.search.rest;

import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.nx.search.model.NxSearchModel;
import com.nx.search.service.INxSearchService;
import com.nx.search.utils.Result;
import com.nx.search.utils.SysConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value="/nx")
public class NxRest {

	@Autowired
    private INxSearchService jobService;
	@Autowired
	DefaultKaptcha defaultKaptcha;

	/**
	 * 导入excel
	 * @throws Exception
	 */
	@PostMapping(value="/import")
	public Result importExl(@RequestParam MultipartFile file) throws Exception {
		return jobService.importData(file) ;
	}

    /**
     * 查询数据
	 * @param pageNum
     * @param pageSize
     * @return
     */
	@GetMapping(value="/data")
	public Map<String, Object> queryData(@RequestParam(value="pageNum")Integer pageNum,
										@RequestParam(value="pageSize")Integer pageSize) {

		Result result = jobService.findAllByPage(pageNum, pageSize);
		PageInfo<NxSearchModel> jobPagers = null ;
		if(result.getSuccess()) jobPagers = (PageInfo<NxSearchModel>) result.getData();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nx", jobPagers);
		map.put("number", jobPagers.getTotal());

		return map;
	}

	/**
	 * 验证码
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws Exception
	 */
	@GetMapping(value = "/captcha")
	public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
		byte[] captchaChallengeAsJpeg = null;
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		try {
			//生产验证码字符串并保存到session中
			String createText = defaultKaptcha.createText();
			httpServletRequest.getSession().setAttribute(SysConstant.SESSION_GENERATED_CAPTCHA_KEY, createText);
			//使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
			BufferedImage challenge = defaultKaptcha.createImage(createText);
			ImageIO.write(challenge, "jpg", jpegOutputStream);
		} catch (IllegalArgumentException e) {
			httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		//定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
		captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
		httpServletResponse.setHeader("Cache-Control", "no-store");
		httpServletResponse.setHeader("Pragma", "no-cache");
		httpServletResponse.setDateHeader("Expires", 0);
		httpServletResponse.setContentType("image/jpeg");
		ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
		responseOutputStream.write(captchaChallengeAsJpeg);
		responseOutputStream.flush();
		responseOutputStream.close();
	}

}

