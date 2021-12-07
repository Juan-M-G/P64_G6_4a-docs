const { gql } = require('apollo-server');
const bill_proTypeDefs = gql`

type Bill_pro {
        id = Int!
        amount = Int!
        sub_total = Int!
}
extend type Query {
bill_proById(id:Int!): Bill_pro
}
`;
module.exports = bill_proTypeDefs;