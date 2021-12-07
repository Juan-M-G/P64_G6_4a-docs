const bill_proResolver = {
    Query: {
        bill_proById: async (_, { id }, { dataSources, userIdToken }) => {
            idToken = (await dataSources.authAPI.getUser(userIdToken)).id
            if (id == idToken)
                return dataSources.bill_proAPI.bill_proById(id)
            else
                return null
        }
    }
};
module.exports = bill_proResolver;