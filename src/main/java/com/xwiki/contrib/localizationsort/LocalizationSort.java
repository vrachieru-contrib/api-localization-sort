package com.xwiki.contrib.localizationsort;

import java.text.Collator;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Named;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.script.service.ScriptService;

@Component
@Singleton
@Named("localizationSort")
public class LocalizationSort implements ScriptService
{
    public static List sort(List data, String lang)
    {
        Collator collator = Collator.getInstance(new Locale(lang));
        Collections.sort(data, collator);
        
        return data;
    }
    
    
    public static <T> Map<String, T> sort (Map data, String lang)
    {
        Collator collator = Collator.getInstance(new Locale(lang));
        
        TreeMap<String, T> result = new TreeMap<String, T>(collator);
        result.putAll(data);
        
        return result;
    }
}