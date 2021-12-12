const productResolver = {
    Query: {
        products: ( _, {}, { dataSources, userIdToken }) => {
            if (userIdToken) return dataSources.billAPI.getProducts();
            else return null;
        },

        productById: (_, { id }, { dataSources, userIdToken }) => {
            if (userIdToken) return dataSources.billAPI.getProductById(id);
            else return null;
        }
    },
    Mutation: {
        createProduct: async (_, { product }, { dataSources, userIdToken }) => {
            if (userIdToken) {
                const productInput = {
                    product_name: product.name,
                    product_stock: product.stock,
                    product_price: product.price,
                }
                return await dataSources.billAPI.createProduct(productInput);
            } else {
                return null;
            }
        },
        updateProduct: async (_, { product }, { dataSources, userIdToken }) => {
            if (userIdToken){
                const productInput = {
                    id: product.id,
                    product_name: product.name,
                    product_stock: product.stock,
                    product_price: product.price,
                    is_active: product.active,
                }
                return await dataSources.billAPI.updateProduct(productInput);
            } else {
                return null;
            }
        },
        deleteProduct: async (_, { id }, { dataSources, userIdToken }) => {
            if (userIdToken) return await dataSources.billAPI.deleteProduct(id);
            else return null;
        }
    },
};

module.exports = productResolver;