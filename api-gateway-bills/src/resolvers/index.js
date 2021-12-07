const bills_resolver = require('./bills_resolver');
const bill_pro_resolver = require('./bill_pro_resolver');
const lodash = require('lodash');
const resolvers = lodash.merge(bill_pro_resolver, bills_resolver);
module.exports = resolvers;