package com.yilinker.core.constants;

/**
 * Created by J.Bautista on 5/11/16.
 */
public class SellerAPIConstants {

    //Warehouse API
    public static final String WAREHOUSE_API                                                          = "warehouse";

    //Get Warehouse List
    public static final String  GET_WAREHOUSE_LIST                                                    = String.format("%s/list", WAREHOUSE_API);

    //Delete Warehouse
    public static final String DELETE_WAREHOUSE                                                       = String.format("%s/delete", WAREHOUSE_API);
    public static final String DELETE_WAREHOUSE_PARAM_ID                                              = "warehouseId";

    //Update Warehouse
    public static final String ADD_UPDATE_WAREHOUSE                                                   = String.format("%s/form", WAREHOUSE_API);
    public static final String ADD_UPDATE_WAREHOUSE_PARAM_ID                                          = "warehouseId";
    public static final String ADD_UPDATE_WAREHOUSE_PARAM_NAME                                        = "name";
    public static final String ADD_UPDATE_WAREHOUSE_PARAM_ADDRESS                                     = "address";
    public static final String ADD_UPDATE_WAREHOUSE_PARAM_LOCATION                                    = "location";
    public static final String ADD_UPDATE_WAREHOUSE_PARAM_ZIPCODE                                     = "zipCode";

    //UPDATE INVENTORY
    public final static String WAREHOUSE_INVENTORY_API                                                = String.format("%s/inventory", WAREHOUSE_API);
    public final static String UPDATE_WAREHOUSE_INVENTORY                                             = String.format("%s/update", WAREHOUSE_INVENTORY_API);
    public final static String UPDATE_WAREHOUSE_INVENTORY_PARAM_WAREHOUSE_ID                          = "warehouseId";
    public final static String UPDATE_WAREHOUSE_INVENTORY_PARAM_PRODUCT_UNIT                          = "productUnit";
    public final static String UPDATE_WAREHOUSE_INVENTORY_PARAM_QUANTITY                              = "quantity";

    //GET SELLER INVENTORY
    public final static String GET_WAREHOUSE_INVENTORY_PARAM_ID                                        = "warehouseId";
    public final static String GET_WAREHOUSE_INVENTORY_PARAM_PAGE_ID                                   = "page";
    public final static String GET_WAREHOUSE_INVENTORY_PARAM_CATEGORY                                  = "category";
    public final static String GET_WAREHOUSE_INVENTORY_PARAM_STATUS                                    = "status";
    public final static String GET_WAREHOUSE_INVENTORY_PARAM_QUERY                                     = "query";
    public final static String GET_WAREHOUSE_INVENTORY_PARAM_GROUP                                     = "group";

    //GET INVENTORY FILTER
    public final static String GET_WAREHOUSE_INVENTORY_FILTER                                          = String.format("%s/inventory-filter", WAREHOUSE_API);

}
