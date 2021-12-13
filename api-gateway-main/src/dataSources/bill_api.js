const { RESTDataSource } = require('apollo-datasource-rest');
const serverConfig = require('../server');

class BillAPI extends RESTDataSource {
    constructor() {
        super();
        this.baseURL = serverConfig.bill_api_url;
    }

    async createBill(bill) {
        bill = new Object(JSON.parse(JSON.stringify(bill)));
        return await this.post('/bill/', bill)
    }

    // async getBills() {
    //     return await this.get('/bills');
    // }

    async getBillById(id_bill) {
        let obje = await this.get(`/bill/${id_bill}`);
     //   console.log(obje.product);
        return obje;
    }

    // async updateBill(bill) {
    //     bill = new Object((JSON).parse(JSON.stringify(bill)));
    //     return await this.put(`/bill/${bill.id}/`, bill);
    // }

    // async deleteBill(id) {
    //     return await this.delete(`/bill/${id}`);
    // }

    async createProduct(product) {
        product = new Object(JSON.parse(JSON.stringify(product)));
        return await this.post('/products/', product)
    }

    async getProducts() {
        return await this.get('/products');
    }

    async getProductById(id) {
        return await this.get(`/products/${id}`);
    }

    async updateProduct(product) {
        product = new Object((JSON).parse(JSON.stringify(product)));
        return await this.put(`/products/${product.id}/`, product);
    }

    async deleteProduct(id) {
        return await this.delete(`/products/${id}`);
    }

}

module.exports = BillAPI;