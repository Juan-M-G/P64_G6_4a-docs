from rest_framework import generics
from factura.models.user import User
from factura.serializers.userSerializer import UserSerializer
from rest_framework.response import Response


class UserDetailView(generics.RetrieveAPIView):
    queryset = User.objects.all()
    serializer_class = UserSerializer
    #Update feature applied to User table across PUT method, according to Rest_Framework
    def put(self, request, pk = None):
        user = User.objects.filter(id = pk).first()
        user_serializer = UserSerializer(user, data = request.data)
        if user_serializer.is_valid():
            user_serializer.save()
            return Response(user_serializer.data)
        return Response(user_serializer.errors)
