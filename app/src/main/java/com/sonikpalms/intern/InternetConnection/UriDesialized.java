package com.sonikpalms.intern.InternetConnection;

import android.net.Uri;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by Sonikpalms on 24.08.2017.
 * Dont use in programm
 */

public class UriDesialized implements JsonDeserializer<Uri>{
    @Override
    public Uri deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String urlString = json.getAsString();

        Uri uri = Uri.parse(urlString);

        return uri;
    }
}
