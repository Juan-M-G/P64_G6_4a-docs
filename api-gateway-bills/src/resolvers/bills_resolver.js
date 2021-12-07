const billResolver = {
    Query: {
        billById: async (_, { id }, { dataSources, userIdToken }) => {
            idToken = (await dataSources.authAPI.getUser(userIdToken)).id
            if (id == idToken)
                return await dataSources.billAPI.billById(id)
            else
                return null

        },
    },
    Mutation: {}
};
module.exports = billResolver;