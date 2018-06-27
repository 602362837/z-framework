package cn.com.zyj.spring.factory.resource;

import java.io.InputStream;
import java.util.Map;

import org.ho.yaml.Yaml;

import cn.com.zyj.spring.exception.ResourceReaderException;
import cn.com.zyj.spring.factory.resource.yaml.base.BaseYamlReader;
import cn.com.zyj.spring.utils.StringUtil;

/**
 * yaml资源阅读器
 * 
 * @author Administrator
 *
 */
public class DefaultYamlReader extends BaseYamlReader {
	@SuppressWarnings("unchecked")
	public DefaultYamlReader(String resourcePath) {
		if (StringUtil.back(resourcePath))
			return;
		resourcePath = resourcePath.startsWith("/") ? resourcePath : "/" + resourcePath;
		InputStream resourceInStream = DefaultYamlReader.class.getResourceAsStream(resourcePath);
		if (resourceInStream == null)
			new ResourceReaderException("yaml文件获取失败：" + resourcePath);
		Map<String, Object> configMap = (Map<String, Object>) Yaml.load(resourceInStream);
		ResourceReader.Config.setConfig(configMap);

	}
}
