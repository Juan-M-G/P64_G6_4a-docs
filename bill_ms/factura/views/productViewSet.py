from rest_framework import viewsets

from factura.models.product import Product
from factura.serializers.productSerializer import ProductSerializer


class ProductViewSet(viewsets.ModelViewSet):
    queryset = Product.objects.all()
    serializer_class = ProductSerializer