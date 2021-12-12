const billResolver = {
    Query: {
        // bills: ( _, {}, { dataSources, userIdToken }) => {
        //     if (userIdToken) return dataSources.productAPI.getBills();
        //     else return null;
        // },

        productById: (_, { id }, { dataSources, userIdToken }) => {
            if (userIdToken) return dataSources.billAPI.getBillById(id);
            else return null;
        }
    },
    Mutation: {
        createBill: async (_, { bill }, { dataSources, userIdToken }) => {
            if (userIdToken) {
                const billInput = {
                    client_name: bill.client_name,
                    purchase_Date: bill.purchase_Date,
                    isActive: bill.isActive,
                    user_id: bill.user_id,
                    products: bill.BillDetail,
                }
                return await dataSources.billAPI.createBill(billInput);
            } else {
                return null;
            }
        },
        // updateBill: async (_, { bill }, { dataSources, userIdToken }) => {
        //     if (userIdToken){
        //         const billInput = {
        //             id_bill: bill.id_bill,
        //             client_name: bill.client_name,
        //             purchase_Date: bill.purchase_Date,
        //             isActive: bill.isActive,
        //             user_id: bill.user_id,
        //             products: bill.products,
        //         }
        //         return await dataSources.billAPI.updateBill(billInput);
        //     } else {
        //         return null;
        //     }
        // },
        // deleteBill: async (_, { id }, { dataSources, userIdToken }) => {
        //     if (userIdToken) return await dataSources.billAPI.deleteBill(id);
        //     else return null;
        // }
    },
};

module.exports = billResolver;