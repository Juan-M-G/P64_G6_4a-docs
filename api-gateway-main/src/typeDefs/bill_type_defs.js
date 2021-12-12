const { gql } = require("apollo-server");

const billTypeDefs = gql`
  type BillDetail {
    product_name: String!
    product_amount: Int!
  }

  type Bill {
    id_bill: Int!
    client_name: String!
    purchase_Date: String!
    isActive: Boolean!
    user_id: Int!
    products: [BillDetail!]!
  }

  input BillInput {
    id_bill: Int!
    client_name: String!
    purchase_Date: String!
    isActive: Boolean!
    user_id: Int!
    products: String!
  }

  extend type Query {
    billById(id_bill: Int!): Bill
  }

  extend type Mutation {
    createBill(bill: BillInput!): Bill
  }
`;

module.exports = billTypeDefs;
