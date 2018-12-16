package com.iusofts.blades.job.common.util;

import java.util.ArrayList;
import java.util.List;

import com.iusofts.blades.job.common.page.PagingResult;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 * dto转换工具
 */
public class ModelMapperUtil {

    private static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);//精准匹配
    }

    /**
     * dto转换-通用精确匹配
     * (精确匹配是指只copy相同属性名的值)
     * 自定义匹配规则请参考：http://modelmapper.org/getting-started/ 的‘Explicit Mapping’部分
     *
     * @param source
     * @param destinationType
     * @return
     */
    public static <D> D strictMap(Object source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    /**
     * List&lt;dto>转换
     *
     * @param source
     * @param componentType
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <D> List<D> strictMapList(Object source, final Class<D> componentType) {
        List<D> list = new ArrayList<D>();
        List<Object> objectList = (List<Object>) source;
        for (Object obj : objectList) {
            list.add(modelMapper.map(obj, componentType));
        }
        return list;
    }

    /**
     * Page&lt;dto>转换
     *
     * @param source
     * @param componentType
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <D> PagingResult<D> strictPage(Object source, final Class<D> componentType) {
        PagingResult<Object> objPage = (PagingResult<Object>) source;
        List<D> list = strictMapList(objPage.getDataList(), componentType);
        PagingResult<D> page = new PagingResult<D>(objPage.getTotalCount(), objPage.getTotalPage(), list);
        return page;
    }

}
