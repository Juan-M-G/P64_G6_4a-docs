from django.db import models
from .product import Product

class Bill(models.Model):
    id_bill = models.AutoField(primary_key=True)
    client_name = models.CharField('Client Name', max_length=30)
    purchase_Date = models.DateTimeField()
    isActive = models.BooleanField(default=True)
    #Definition of ManyTomany Relation between bill and products tables, through Fact_Prod table.
    products = models.ManyToManyField(Product, related_name= 'products', through= 'Fact_prod')
    user_id = models.IntegerField(default=0)