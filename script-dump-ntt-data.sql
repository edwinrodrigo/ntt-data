PGDMP                          |            ntt-data    14.13    15.3     E           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            F           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            G           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            H           1262    16384    ntt-data    DATABASE     u   CREATE DATABASE "ntt-data" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE "ntt-data";
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            I           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    4            J           0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   postgres    false    4            �            1259    16386    clientes    TABLE     K  CREATE TABLE public.clientes (
    id bigint NOT NULL,
    direccion character varying(255),
    edad integer,
    genero character varying(255),
    identificacion character varying(255),
    nombre character varying(255),
    telefono character varying(255),
    contrasena character varying(255),
    estado boolean NOT NULL
);
    DROP TABLE public.clientes;
       public         heap    postgres    false    4            �            1259    16385    clientes_id_seq    SEQUENCE     �   ALTER TABLE public.clientes ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.clientes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210    4            �            1259    32785    cuentas    TABLE     �   CREATE TABLE public.cuentas (
    cuenta_id bigint NOT NULL,
    estado boolean NOT NULL,
    id_cliente bigint,
    numero_cuenta character varying(255),
    saldo_inicial double precision,
    tipo_cuenta character varying(255)
);
    DROP TABLE public.cuentas;
       public         heap    postgres    false    4            �            1259    32784    cuentas_cuenta_id_seq    SEQUENCE     �   ALTER TABLE public.cuentas ALTER COLUMN cuenta_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.cuentas_cuenta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    4    212            �            1259    32799    movimientos    TABLE       CREATE TABLE public.movimientos (
    movimiento_id uuid NOT NULL,
    fecha timestamp(6) without time zone,
    movimiento_inicial boolean NOT NULL,
    saldo double precision,
    tipo_movimiento character varying(255),
    valor double precision,
    cuenta_id bigint NOT NULL
);
    DROP TABLE public.movimientos;
       public         heap    postgres    false    4            ?          0    16386    clientes 
   TABLE DATA           u   COPY public.clientes (id, direccion, edad, genero, identificacion, nombre, telefono, contrasena, estado) FROM stdin;
    public          postgres    false    210   �       A          0    32785    cuentas 
   TABLE DATA           k   COPY public.cuentas (cuenta_id, estado, id_cliente, numero_cuenta, saldo_inicial, tipo_cuenta) FROM stdin;
    public          postgres    false    212   �       B          0    32799    movimientos 
   TABLE DATA           y   COPY public.movimientos (movimiento_id, fecha, movimiento_inicial, saldo, tipo_movimiento, valor, cuenta_id) FROM stdin;
    public          postgres    false    213   �       K           0    0    clientes_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.clientes_id_seq', 39, true);
          public          postgres    false    209            L           0    0    cuentas_cuenta_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.cuentas_cuenta_id_seq', 88, true);
          public          postgres    false    211            �           2606    16392    clientes clientes_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.clientes DROP CONSTRAINT clientes_pkey;
       public            postgres    false    210            �           2606    32791    cuentas cuentas_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.cuentas
    ADD CONSTRAINT cuentas_pkey PRIMARY KEY (cuenta_id);
 >   ALTER TABLE ONLY public.cuentas DROP CONSTRAINT cuentas_pkey;
       public            postgres    false    212            �           2606    32803    movimientos movimientos_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT movimientos_pkey PRIMARY KEY (movimiento_id);
 F   ALTER TABLE ONLY public.movimientos DROP CONSTRAINT movimientos_pkey;
       public            postgres    false    213            �           2606    32805 #   cuentas uk7h7mqvcau3mcl0mbrkdrt7fnh 
   CONSTRAINT     g   ALTER TABLE ONLY public.cuentas
    ADD CONSTRAINT uk7h7mqvcau3mcl0mbrkdrt7fnh UNIQUE (numero_cuenta);
 M   ALTER TABLE ONLY public.cuentas DROP CONSTRAINT uk7h7mqvcau3mcl0mbrkdrt7fnh;
       public            postgres    false    212            �           2606    32806 '   movimientos fk4moe88hxuohcysas5h70mdc09    FK CONSTRAINT     �   ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT fk4moe88hxuohcysas5h70mdc09 FOREIGN KEY (cuenta_id) REFERENCES public.cuentas(cuenta_id);
 Q   ALTER TABLE ONLY public.movimientos DROP CONSTRAINT fk4moe88hxuohcysas5h70mdc09;
       public          postgres    false    213    3245    212            ?   �   x�E��� E��W��Op��������8� XE���.]��=9%��r�o���Z?څ�Z(�RH��6Єm�i�4�J�!2י��Ӗ]7�|��khi��'G�>�;B���+�S��R���mH��{�>���%x�e�,��f'��-�6[��
�N-
��ya�� 7�      A      x������ � �      B      x������ � �     