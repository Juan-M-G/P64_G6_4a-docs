<template>
  <div v-if="loaded" class="information">
    <h1>Información de su factura</h1>
    <h3>
      Número de factura: <span>{{ id_bill }}</span>
    </h3>
    <h3>
      Vendedor: <span>{{ user }}</span>
    </h3>
    <h3>
      Cliente: <span>{{ client_name }}</span>
    </h3>
    <h3>
      Fecha de compra: <span>{{ purchase_date }}</span>
    </h3>
    <!-- <h3>
      Productos: <span>{{ product }}</span>
    </h3> -->
    <table class="table">
      <tr>
        <th>Producto</th>
        <th>Cantidad</th>
        <th>Precio Unidad</th>
        <th>Precio total</th>
      </tr>
      <tr v-for="pro in product" v-bind:key="pro">
        <td v-text="pro.product_name"></td>
        <td v-text="pro.product_amount"></td>
        <td v-text="pro.product_price"></td>
        <td v-text="pro.sub_total_price"></td>
      </tr>
    </table>
    <h3>
      Valor total a cancelar: <span>{{ total_bill }}</span>
    </h3>
  </div>
</template>


<script>
import gql from "graphql-tag";
import jwt_decode from "jwt-decode";
export default {
  name: "Bill",
  data: function () {
    return {
      id_bill: jwt_decode(localStorage.getItem("token_refresh")).id_bill,
      billById: {
        id_bill: "",
        client_name: "",
        purchase_date: "",
        otal_bill: "",
        user: "",
        product: {
          product_name: "",
          product_amount: "",
          product_price: "",
          sub_total_price: ""
        }
      },
    };
  },
  apollo: {
    userDetailById: {
      query: gql`
        query ($id_bill: Int!) {
          billById(id_bill: Int!) {
              id_bill
              client_name
              purchase_date
              total_bill
              user
              product {
                product_name
                product_amount
                product_price
                sub_total_price
            }
          }
        }
      `,
      variables() {
        return {
          userId: this.userId,
        };
      },
    },
  },
};
</script>


<style>
.information {
  margin: 0;
  padding: 0%;
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.information h1 {
  font-size: 60px;
  color: #0f1316;
}
.information h3 {
  margin: 10px;
}
.information span {
  color: crimson;
  font-weight: bold;
}
.table {
  text-align: center;
}

.table th {
  width: 200px;
}
</style>