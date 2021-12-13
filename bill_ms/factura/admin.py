from django.contrib import admin
from .models.product import Product
from .models.bill import Bill
from .models.fact_prod import Fact_prod

admin.site.register(Product)
admin.site.register(Fact_prod)
admin.site.register(Bill)

