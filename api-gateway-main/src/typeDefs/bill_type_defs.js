const { gql } = require("apollo-server");

const billTypeDefs = gql`
  
type BillDetail{
    product_name: String!
    product_amount: Int!
    product_price: Int
    sub_total_price: Int
  }
  
   type Bill {
    id_bill: Int
    client_name: String
    purchase_date: String
    total_bill: Int
    user: Int
    product:[BillDetail]
  }

  input BillInput {
    client_name: String
    purchase_Date: String
    isActive: Boolean
    user_id: Int
    products: [BillDetailInput]
  }

  input BillDetailInput{
    product_name: String!
    product_amount: Int!
  }

  extend type Query {
    billById(id_bill: Int!): Bill
  }

  extend type Mutation {
    createBill(bill: BillInput!): Bill
  }
`;

module.exports = billTypeDefs;
