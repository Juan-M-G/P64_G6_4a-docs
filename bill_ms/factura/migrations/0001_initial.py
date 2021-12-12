# Generated by Django 3.2.8 on 2021-12-12 17:30

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Bill',
            fields=[
                ('id_bill', models.AutoField(primary_key=True, serialize=False)),
                ('client_name', models.CharField(max_length=30, verbose_name='Client Name')),
                ('purchase_Date', models.DateTimeField()),
                ('isActive', models.BooleanField(default=True)),
                ('user_id', models.IntegerField(default=0)),
            ],
        ),
        migrations.CreateModel(
            name='Product',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('product_name', models.CharField(max_length=150, verbose_name='ProductName')),
                ('product_stock', models.IntegerField(default=0)),
                ('product_price', models.IntegerField(default=0)),
                ('is_active', models.BooleanField(default=True)),
            ],
            options={
                'verbose_name': 'Producto',
                'verbose_name_plural': 'Productos',
                'db_table': 'Product',
                'ordering': ['id'],
            },
        ),
        migrations.CreateModel(
            name='Fact_prod',
            fields=[
                ('id_fp', models.AutoField(primary_key=True, serialize=False)),
                ('product_amount', models.IntegerField(default=0)),
                ('sub_total_price', models.IntegerField(default=0)),
                ('bill_id', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='fact_prod', to='factura.bill')),
                ('product_id', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='fact_prod', to='factura.product')),
            ],
        ),
        migrations.AddField(
            model_name='bill',
            name='products',
            field=models.ManyToManyField(related_name='products', through='factura.Fact_prod', to='factura.Product'),
        ),
    ]