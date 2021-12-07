const { RESTDataSource } = require('apollo-datasource-rest');
const serverConfig = require('../server');
class BillAPI extends RESTDataSource {
    constructor() {
        super();
        this.baseURL = serverConfig.bill_api_url;
    }
    async createBill(bill) {
        bill = new Object(JSON.parse(JSON.stringify(bill)));
        return await this.post('/bills', bill);
    }
    async billById(id) {
        return await this.get(`/bill/${id}`);
    }
    async allBills() {
        return await this.get(`/bill/`);
    }
}
module.exports = BillAPI;