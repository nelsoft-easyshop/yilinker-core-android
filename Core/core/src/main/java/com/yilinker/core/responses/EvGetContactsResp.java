package com.yilinker.core.responses;

import com.google.gson.annotations.SerializedName;
import com.yilinker.core.model.Contact;

import java.util.List;

/**
 * Created by Jeico on 8/21/2015.
 */
public class EvGetContactsResp extends EvBaseResp
{
    @SerializedName("data")
    public List<Contact> contactList;
}
