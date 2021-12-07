const { gql } = require('apollo-server');
const billTypeDefs = gql`

type Bill {
        id: Int!
        clientName: String!
        isActive Boolean!
        billDate String!
}
extend type Query {
billById(id:Int!): Bill
}
`;
module.exports = billTypeDefs;