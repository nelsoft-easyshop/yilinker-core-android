package com.yilinker.core.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Arci.Malabanan on 2/27/2015.
 */
public class DateSerializer implements JsonSerializer<Date>
{
    @Override
    public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return new JsonPrimitive(sdf.format(date));
    }
}
