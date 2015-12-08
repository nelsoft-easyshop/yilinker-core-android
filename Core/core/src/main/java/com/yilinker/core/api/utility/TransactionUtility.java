package com.yilinker.core.api.utility;

import android.content.Context;
import android.util.SparseArray;

import com.yilinker.core.R;

/**
 * Created by jaybr_000 on 12/8/2015.
 */
public class TransactionUtility {

    private Context context;
    private static TransactionUtility transactionUtility;
    private static SparseArray<String> statusTypes;

    /**
     * creates an instance of transaction utility
     * @param context
     * @return
     */
    public static TransactionUtility getInstance(Context context, boolean isBuyer) {

        if (transactionUtility == null) {
            transactionUtility = new TransactionUtility();

            statusTypes = new SparseArray<>();
            statusTypes.put(1, context.getString(R.string.transaction_type_on_going));
            statusTypes.put(2, context.getString(R.string.transaction_type_on_going));
            statusTypes.put(3, isBuyer ? context.getString(R.string.transaction_type_for_feedback)
                    : context.getString(R.string.transaction_type_completed));
            statusTypes.put(4, isBuyer ? context.getString(R.string.transaction_type_on_going)
                    : context.getString(R.string.transaction_type_cancelled));
            statusTypes.put(5, isBuyer ? context.getString(R.string.transaction_type_on_going)
                    : context.getString(R.string.transaction_type_completed));
            statusTypes.put(6, isBuyer ? context.getString(R.string.transaction_type_on_delivery)
                    : context.getString(R.string.transaction_type_on_going));
            statusTypes.put(7, context.getString(R.string.transaction_type_on_going));
            statusTypes.put(8, isBuyer ? context.getString(R.string.transaction_type_on_going)
                    : context.getString(R.string.transaction_type_cancelled));
            statusTypes.put(9, context.getString(R.string.transaction_type_on_going));
            statusTypes.put(10, context.getString(R.string.transaction_type_on_going));
            statusTypes.put(11, context.getString(R.string.transaction_type_on_going));

        }

        transactionUtility.context = context;

        return transactionUtility;
    }

    /**
     * returns the status type name
     * @param statusId
     * @return
     */
    public String getTypeName(int statusId) {

        String typeName = statusTypes.get(statusId);

        return typeName == null ?
                context.getString(R.string.transaction_type_undefined) :
                typeName;

    }

}
